package gate;
import core.*;

public interface TwoQubitGate {
	
	public Qubit[] actOn(State q1, State q2);

	public Qubit[] actOn(State q1, State q2, double phase);

}
