package gate;
import core.*;

public class ControlledPhase implements TwoQubitGate {

	@Override
	public State[] actOn(Qubit x, Qubit y, double phase) {
		
		Phase phaseGate = new Phase();
		
		State xState = phaseGate.actOn(x, phase);
		State yState = phaseGate.actOn(y, phase);
		
		State[] returnStates = {xState, yState};
		return returnStates;
	}
	
	/**
	 * This is a test main method to check that the Controlled Phase Gate gives appropriate state output.
	 * @param args
	 */
	public static void main(String[] args){
		double phaseShift = 45;
		
		Qubit x = new Qubit(1);
		Qubit y = new Qubit(1);
		
		ControlledPhase gate = new ControlledPhase();
		
		State[] states = gate.actOn(x, y, phaseShift);
		for(State state: states){
			System.out.println(state.toString());
		}
	}

	@Override
	public State[] actOn(Qubit q1, Qubit q2) {
		new Exception("Controlled Phase gate must have parameter 'phase' of type double.");
		return null;
	}
	

}
