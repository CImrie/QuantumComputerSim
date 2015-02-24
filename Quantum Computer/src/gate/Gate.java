package gate;

import core.*;



public interface Gate {
	public State actOn(Qubit q);
	
	//public Register actOnRegister(Register r);
}
