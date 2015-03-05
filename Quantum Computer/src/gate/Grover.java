package gate;
import core.*;
import gate.Hadamard;
import gate.Phase;
/* Class that implements gates to perform the Grover step alogrithm
 * @Author Ben Crabbe
 * */
 
public class Grover {

	
	public static Register turnOn() {
		
		Hadamard h = new Hadamard();
		
		Qubit newone = h.actOn(new Qubit(new State(0)));
		Qubit newtwo = h.actOn(new Qubit(new State(0)));
		
		Register r = new Register(2);
		r.setState(newone, 0);
		r.setState(newtwo, 1);
		
		return r;
	}
	public static void main(String[] args) {
		
		Hadamard H = new Hadamard();
		Register r = new Register(2);
		r = turnOn();
		Phase p = new Phase();
		r.setState(p.actOn(r.getQubit(1),Math.PI),1);
		
		System.out.println(r.getMatrix());
		//System.out.println(r.getQubit(1).getMatrix());
		
	r.setState(H.actOn(r.getQubit(0)), 0);
	r.setState(H.actOn(r.getQubit(1)), 1);
		
		// TODO there is a problem with the tensor priduct
		
		System.out.println(r.getMatrix());
		//System.out.println(r.getQubit(1).getMatrix());
	}
}
