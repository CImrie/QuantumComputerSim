package gate;
import core.*;

public interface TwoQubitGate {
	
	public State[] actOn(Qubit q1, Qubit q2);

}
