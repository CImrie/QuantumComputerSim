package gate;
import core.*;
public interface FOneQubitGate {

public ListRegister actOn(ListRegister r, int qubitIndex) ;
	
public ListQubit actOn(ListQubit q) ;
public ListRegister actOn(ListRegister r) ;
}