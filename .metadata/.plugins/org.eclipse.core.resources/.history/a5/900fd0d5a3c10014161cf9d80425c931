package gate;
import core.*;

public class Phase implements OneQubitGate{

	@Override
	public State actOn(Qubit q, double phase) {
		//check coefficients to each qubit
		if (q.getQubitType() == 0){
			return (new State(new Complex(1, 0), new Complex(0,0)));
		}
		else if(q.getQubitType() == 1){
			// Use Euler
			double realPart = Math.cos(phase);
			double complexPart = Math.sin(phase);
			Complex toOutput = new Complex(realPart,complexPart);
			return (new State(new Complex(0,0), toOutput));
		}
		return null;
	}
	
	/**
	 * This is a test main method to check that Phase Gate gives appropriate state output.
	 * @param args
	 */
	public static void main(String[] args){
		Phase p = new Phase();
		double phaseShift = 45;
		State newS = p.actOn(new Qubit(1),phaseShift);
		System.out.println(newS.toString());
	}

	@Override
	public State actOn(Qubit q) {
		new Exception("Phase gate must have parameter 'phase' of type double.");
		return null;
	}

}
