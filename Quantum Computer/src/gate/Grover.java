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
		r.setQubit(newone, 0);
		r.setQubit(newtwo, 1);
		
		return r;
	}
	public static void main(String[] args) {
		
		Hadamard H = new Hadamard();
		Register r = new Register(2);
		r = turnOn();
		Phase p = new Phase();
		r.setQubit(p.actOn(r.getQubit(1),Math.PI),1);
		
		System.out.println(r.getMatrix());
		//System.out.println(r.getQubit(1).getMatrix());
		
	r.setQubit(H.actOn(r.getQubit(0)), 0);
	r.setQubit(H.actOn(r.getQubit(1)), 1);
		
		// TODO there is a problem with the tensor priduct
		
		System.out.println(r.getMatrix());
		//System.out.println(r.getQubit(1).getMatrix());
		
		//connor's example
		Hadamard h = new Hadamard();
		Register r2 = new Register(2);
		Qubit q1 = new Qubit(new State(0));
		Qubit q2 = new Qubit(new State(0));
		r2.setQubit(h.actOn(q1), 0);
		r2.setQubit(h.actOn(q2), 1);
		
		Phase p2 = new Phase();
		r2.setQubit(p2.actOn(r2.getQubit(1), Math.PI), 1);
		System.out.println(r2.getMatrix());
		
		r2.setQubit(h.actOn(r2.getQubit(0)), 0);
		r2.setQubit(h.actOn(r2.getQubit(1)), 1);
		
		System.out.println(r2.getMatrix());
		
	}
}
