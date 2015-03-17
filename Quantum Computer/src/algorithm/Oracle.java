package algorithm;
import core.*;
import gate.*;

/* Class that implements gates to perform the Grover step alogrithm
 * @Author Ben Crabbe
 * */

public class Oracle extends OneQubitGate {
	
	public Oracle(int size, int index){
		Matrix m = Matrix.identity(size);
		m.setElement(new Complex(-1), index, index);
		this.matrix = m;
	}

	public Register actOn(Register r) {
		/*int length = r.getLength();

		Matrix O = new Matrix((int)Math.pow(2, length));
		if(oracle > Math.pow(2, length)-1) throw new RuntimeException("Oracle index exceeds dimension of matrix");
		for(int i = 0; i < Math.pow(2,length); i++) {
			if(oracle == i) {
				O.setElement(new Complex(-1.0,0.0), i, i);
			} else { 
				O.setElement(new Complex(1.0,0.0), i, i);
			}
		}
		return O;*/
		
		return new Register(this.matrix.mult(r));
	}
}