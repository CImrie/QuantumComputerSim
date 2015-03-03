package gate;
import core.*;

public class Phase implements OneQubitGate{

	@Override
	public Qubit actOn(Qubit q, double phase) {
		Complex a = q.get0();
		Complex b = q.get1();
		double realPart = Math.cos(phase);
		double imagPart = Math.sin(phase);
		Complex e = new Complex(realPart, imagPart);
		return new Qubit(a, b.multiply(e));
	}
	
	/**
	 * This is a test main method to check that Phase Gate gives appropriate state output.
	 * @param args
	 */
	public static void main(String[] args){
		Phase p = new Phase();
		double phaseShift = Math.PI/4;
		Qubit newS = p.actOn(new Qubit(new State(1)),phaseShift);
		System.out.println(newS.toString());
	}

	@Override
	public Qubit actOn(Qubit q) {
		new Exception("Phase gate must have parameter 'phase' of type double.");
		return null;
	}

}
