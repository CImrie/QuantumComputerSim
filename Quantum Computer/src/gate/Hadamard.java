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
		if(qubitIndex >= rSize) throw new RuntimeException("Register incorrect size. Register has " + rSize + " qubits");
		Matrix m = new Matrix(1);
		m.setElement(new Complex(1), 0, 0);
		for (int i = 0; i < rSize; i++){
			if (i == qubitIndex){
				m = this.matrix.getTensorProduct(m);
			}
			else {
				m = Matrix.identity(2).getTensorProduct(m);
			}
		}
			m = m.mult(r.getMatrix());
		//return new Register(m) ;
			return new Register(m);
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
		m = m.mult(r.getMatrix());
		return new Register(m);
	}
	/**
	 * This is a test main method to check that hadamard gives appropriate state output.
	 * @param args
	 */
	public static void main(String[] args){
		Hadamard h = new Hadamard();
		Qubit[] qubits = new Qubit[5];
		qubits[0] = new Qubit(new State(0));
		qubits[1] = new Qubit(new State(0));
		qubits[2] = new Qubit(new State(0));
		qubits[3] = new Qubit(new State(0));
		qubits[4] = new Qubit(new State(0));
		Register r = new Register(qubits);

		Register m = h.actOn(r);
		System.out.println(m);
	}

		@Override
		public Qubit actOn(Qubit q, double parameter) {
			return actOn(q);
		}
}
