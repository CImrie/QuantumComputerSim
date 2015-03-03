package gate;
import core.*;

public class Phase implements OneQubitGate{

	@Override
	public Qubit actOn(Qubit q, double phase) {
		//check coefficients to each qubit
		
		/*if (q.getStateType() == 0){
			return (new Qubit(new Complex(1, 0), new Complex(0,0)));
		}
		else if(q.getStateType() == 1){
			// Use Euler
			double realPart = Math.cos(phase);
			double complexPart = Math.sin(phase);
			Complex toOutput = new Complex(realPart,complexPart);
			return (new Qubit(new Complex(0,0), toOutput));
		}
		return null;*/
		return null;
	}
	
	/**
	 * This is a test main method to check that Phase Gate gives appropriate state output.
	 * @param args
	 */
	public static void main(String[] args){
		Phase p = new Phase();
		double phaseShift = 45;
		Qubit newS = p.actOn(new Qubit(new State(1)),phaseShift);
		System.out.println(newS.toString());
	}

	@Override
	public Qubit actOn(Qubit q) {
		new Exception("Phase gate must have parameter 'phase' of type double.");
		return null;
	}

}
