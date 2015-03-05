package gate;
import core.*;

public class Phase implements OneQubitGate{

	@Override
	public Qubit actOn(Qubit q, double phase) {
		Complex a = q.get0();
		Complex b = q.get1();
		double realPart = Math.cos(phase);
		double imagPart = Math.sin(phase);
		Complex e = new Complex(realPart, imagPart);
		return new Qubit(a, b.multiply(e));
	}
	
	/**
	 * This is a test main method to check that Phase Gate gives appropriate state output.
	 * @param args
	 */
	public static void main(String[] args){
		/*Phase p = new Phase();
		double phaseShift = Math.PI/4;
		Qubit newS = p.actOn(new Qubit(new State(1)),phaseShift);
		System.out.println(newS.toString());
		*/
		Qubit q1 = new Qubit(new Complex(1,0), new Complex(1,0));
		Qubit q2 = new Qubit(new Complex(1,0), new Complex(1,0));
		
		Register r = new Register(2);
		r.setQubit(q1, 0);
		r.setQubit(q2, 1);
		
		Phase p = new Phase();
		Qubit result = p.actOn(r.getQubit(1), Math.PI);
		r.setQubit(result, 1);
		System.out.println(r.getMatrix());
	}

	@Override
	public Qubit actOn(Qubit q) {
		new Exception("Phase gate must have parameter 'phase' of type double.");
		return null;
	}

}
