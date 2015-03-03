package gate;
import core.State;
import core.Qubit;

/**
 * The C-NOT gate is a 2-qubit gate.
 * It can be represented as a pair of 1 qubit applications
 * @author Connor Imrie
 *
 */
public class CNOT implements TwoQubitGate{

	@Override
	public Qubit[] actOn(State x, State y) {
		State newY;
		if (x.getQubitType() == 1){
			if (y.getQubitType() == 0){
				newY = new State(1);
			}
			else {
				newY = new State(0);
			}
		}
		else {
			newY = y;
		}
		
		Qubit xState = new Qubit(x);
		Qubit yState = new Qubit(newY);
		Qubit[] returnStates = {xState, yState};
		//returns state of 
		return returnStates;
	}
	
	//Test
	public static void main(String[] args){
		State x = new State(1);
		State y = new State(1);
		CNOT gate = new CNOT();
		
		Qubit[] states = gate.actOn(x, y);
		for(Qubit state: states){
			System.out.println(state.toString());
		}
	}

	@Override
	public Qubit[] actOn(State q1, State q2, double phase) {
		new Exception("CNOT can only act on two Qubits. Do not use phase");
		return null;
	}
	
}
