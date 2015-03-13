package gate;
import core.*;

public class Phase extends OneQubitGate{

	public Phase(double phase) {
		Matrix p = new Matrix(2);
		Complex c1 = new Complex(1);
		Complex c0 = new Complex(0);
		Complex c4 = new Complex(Math.cos(phase), Math.sin(phase));
		p.setElement(c1, 0, 0);
		p.setElement(c0, 0, 1);
		p.setElement(c0, 1, 0);
		p.setElement(c4, 1, 1);
		this.matrix = p;
	}
	
	/**
	 * This is a test main method to check that Phase Gate gives appropriate state output.
	 * @param args
	 */
	public static void main(String[] args){
		Qubit[] q = new Qubit[1];
		q[0] = new Qubit(new State(1));
		
		Register r = new Register(q);
		Phase p = new Phase(Math.PI/2);
		r = p.actOn(r);

		System.out.println(r.toString());
	}

}
