package gate;
import core.*;

public class Hadamard implements OneQubitGate{
	private final Matrix matrix;
	
	public Hadamard(){
		Matrix m = new Matrix(2);
		Complex c1 = new Complex(1/Math.sqrt(2));
		Complex c2 = new Complex(-1/Math.sqrt(2));
		m.setElement(c1, 0, 0);
		m.setElement(c1, 0, 1);
		m.setElement(c1, 1, 0);
		m.setElement(c2, 1, 1);
		this.matrix = m;
	}

	@Override
	public Register actOn(Register r, int qubitIndex) {
		int rSize = r.getLength();

		Matrix m = new Matrix(1);
		m.setElement(new Complex(1), 0, 0);
		for (int i = 0; i < rSize; i++){
			if (i == qubitIndex){
				m = m.getTensorProduct(this.matrix);
			}
			else {
				m = m.getTensorProduct(Matrix.identity(2));
			}
	m = this.matrix.mult(r.getMatrix());
		}
		return new Register(m) ;
	}
	
	public Qubit actOn(Qubit q){
		Qubit[] qubits = {q};
		Register r = new Register(qubits);
		r = this.actOn(r, 0);
		Qubit newQ = new Qubit(new Matrix(r.getElements()));
		return newQ;
	}
	
	// Method that acts the Hadamard gate on all the qubits of a register
	public Register actOn(Register r) {
		int rSize = r.getLength();
		Matrix m = new Matrix(1);
		m.setElement(new Complex(1), 0, 0);
		for(int i = 0; i < rSize; i++) {
		m = m.getTensorProduct(this.matrix);
		}
		return new Register(m);
	}
/*	public static Matrix HadamardTensor(int a) {
		Matrix h = createHadamard(1);
		Matrix H = h.getTensorProduct(h);
		return H;
	}
	*/
	/**
	 * This is a test main method to check that hadamard gives appropriate state output.
	 * @param args
	 */
	public static void main(String[] args){
		Hadamard h = new Hadamard();
		Qubit[] qubits = new Qubit[1];
		qubits[0] = new Qubit(new State(0));
		Register r = new Register(qubits);
				
		Register newr = h.actOn(r, 0);
	//	System.out.println((1/newQ.getMagnitude()) + "[ " + newQ.get0() + "|0> +  " + newQ.get1() + "|1> ]");
		System.out.println(newr);
	}

	@Override
	public Qubit actOn(Qubit q, double parameter) {
		return actOn(q);
	}
}
