package gate;
import core.*;

public class ControlledPhase implements TwoQubitGate {

	@Override
	public State actOn(Qubit q1, Qubit q2, double phase) {
		return null;
	}
	
	/**
	 * This is a test main method to check that the Controlled Phase Gate gives appropriate state output.
	 * @param args
	 */
	public static void main(String[] args){
		ControlledPhase p = new ControlledPhase();
		double phaseShift = 45;
		State newS = p.actOn(new Qubit(0, 1),new Qubit(1,0),phaseShift);
		//State s = new State(new Complex(1/newS.getMagnitude(),0),new Complex(1/newS.getMagnitude(),0));
		System.out.println((1/newS.getMagnitude()) + "[ " + newS.get0() + "|0> +  " + newS.get1() + "|1> ]");
	}

	@Override
	public State actOn(Qubit q1, Qubit q2) {
		new Exception("Phase gate must have parameter 'phase' of type double.");
		return null;
	}
	

}
