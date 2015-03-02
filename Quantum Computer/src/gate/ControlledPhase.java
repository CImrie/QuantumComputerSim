package gate;
import core.*;

public class ControlledPhase implements TwoQubitGate {

	@Override
	public State actOn(Qubit q1, Qubit q2, double phase) {
		double realPart = Math.cos(q1.getQubitType()*phase);
		double complexPart = Math.sin(q1.getQubitType()*phase);
		Complex toOutput = new Complex(realPart,complexPart);
		return (new State(new Complex(0,0), toOutput));
	}
	
	/**
	 * This is a test main method to check that the Controlled Phase Gate gives appropriate state output.
	 * @param args
	 */
	public static void main(String[] args){
		ControlledPhase p = new ControlledPhase();
		double phaseShift = 45;
		State newS = p.actOn(new Qubit(0, 1),new Qubit(1,0),phaseShift);
		System.out.println(newS.toString());
	}

	@Override
	public State[] actOn(Qubit q1, Qubit q2) {
		new Exception("Controlled Phase gate must have parameter 'phase' of type double.");
		return null;
	}
	

}
