package gate;
import core.*;

public class Hadamard implements OneQubitGate{
	private final Matrix matrix;
	
	public Hadamard(){
		Matrix m = new Matrix(2);
		Complex c1 = new Complex(1/Math.sqrt(2));
		Complex c2 = new Complex(-1/Math.sqrt(2));
		m.setElement(c1,1,1);
		m.setElement(c1,1,2);
		m.setElement(c1,2,1);
		m.setElement(c2, 2, 2);
		this.matrix = m;
	}

	@Override
	public Register actOn(Register r, int qubitIndex) {
		int rSize = r.getLength();

		Matrix m = new Matrix(1);
		m.setElement(new Complex(1), 1, 1);
		for (int i = 0; i < rSize; i++){
			if (i == qubitIndex){
				m = m.getTensorProduct(this.matrix);
			}
			else {
				m = m.getTensorProduct(Matrix.identity(2));
			}
		}
		return (new Register(m));
	}
	
	public Qubit actOn(Qubit q){
		Qubit[] qubits = {q};
		Register r = new Register(qubits);
		r = this.actOn(r, 0);
		Qubit newQ = new Qubit(new Matrix(r.getElements()));
		return newQ;
	}
	
	/*// Method that acts the Hadamard gate on all the qubits of a register
	public Register actOn(Register r) {
		Hadamard h = new Hadamard();
		int n = r.getLength();
		Register r2 =  new Register(n);
		
		for(int i = 0; i < n; i++) {
		r2.setQubit(h.actOn(r.getQubit(i)), i);
		}
		return r2;
	}
	public static Matrix HadamardTensor(int a) {
		Matrix h = createHadamard(1);
		Matrix H = h.getTensorProduct(h);
		return H;
	}*/
	
	/**
	 * This is a test main method to check that hadamard gives appropriate state output.
	 * @param args
	 */
	public static void main(String[] args){
		Hadamard h = new Hadamard();
		Qubit newQ = h.actOn(new Qubit(new State(0,1)));
		Qubit Q = new Qubit(new Complex(1/newQ.getMagnitude(),0),new Complex(1/newQ.getMagnitude(),0));
		System.out.println((1/newQ.getMagnitude()) + "[ " + newQ.get0() + "|0> +  " + newQ.get1() + "|1> ]");
		System.out.println(Q.prob1());
	}

	@Override
	public Qubit actOn(Qubit q, double parameter) {
		return actOn(q);
	}
}
