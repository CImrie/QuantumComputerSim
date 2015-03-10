package gate;
import core.*;

public class Hadamard implements OneQubitGate{

	@Override
	public Qubit actOn(Qubit qubit) {
		Complex a = qubit.get0();
		Complex b = qubit.get1();
		return new Qubit((a.add(b)), (a.subtract(b)));
	}
	// Method that acts the Hadamard gate on all the qubits of a register
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
	}
	//Matrix rep for Hadamard
	
	public static Matrix createHadamard(int d) {
		Complex[][] c = {{new Complex(1/Math.sqrt(2)),new Complex(1/Math.sqrt(2))},{new Complex(1/Math.sqrt(2)),new Complex(-1/Math.sqrt(2))}};
		Matrix h1 = new Matrix(c);
		return h1;
		
	}
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
