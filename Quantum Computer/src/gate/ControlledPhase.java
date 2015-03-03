package gate;
import core.*;

public class ControlledPhase implements TwoQubitGate {

	@Override
	public Qubit[] actOn(State x, State y, double phase) {
		
		Phase phaseGate = new Phase();
		
		Qubit xState = phaseGate.actOn(x, phase);
		Qubit yState = phaseGate.actOn(y, phase);
		
		
		
		Qubit[] returnStates = {xState, yState};
		return returnStates;
	}
	
	/**
	 * This is a test main method to check that the Controlled Phase Gate gives appropriate state output.
	 * @param args
	 */
	public static void main(String[] args){
		double phaseShift = 45;
		
		State x = new State(1);
		State y = new State(1);
		
		ControlledPhase gate = new ControlledPhase();
		
		Qubit[] states = gate.actOn(x, y, phaseShift);
		for(Qubit state: states){
			System.out.println(state.toString());
		}
	}

	@Override
	public Qubit[] actOn(State q1, State q2) {
		new Exception("Controlled Phase gate must have parameter 'phase' of type double.");
		return null;
	}
	

}
