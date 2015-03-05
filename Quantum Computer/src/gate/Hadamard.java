package gate;
import core.*;

public class Hadamard implements OneQubitGate{

	@Override
	public Qubit actOn(Qubit qubit) {
		Complex a = qubit.get0();
		Complex b = qubit.get1();
		return new Qubit((a.add(b)), (a.subtract(b)));
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
