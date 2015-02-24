package gate;
import core.*;

public class Phase implements Gate{

	@Override
	public State actOn(Qubit q, double phase) {
		//check coefficients to each qubit
		if (q.get0() > 0){
			return (new State(new Complex(1, 0), new Complex(0,0)));
		}
		else if(q.get1() > 0){
			Complex i = new Complex(0,1);
			return (new State(new Complex(0,0), new Complex(0,0)));
		}
		return null;
	}
	
	/**
	 * This is a test main method to check that Phase Gate gives appropriate state output.
	 * @param args
	 */
	public static void main(String[] args){
		Phase p = new Phase();
		State newS = p.actOn(new Qubit(1, 0));
		System.out.println(newS.get0() + "|0> " + newS.get1() + "|1> ");
	}

	@Override
	public State actOn(Qubit q) {
		// TODO Auto-generated method stub
		new Exception("Phase gate must have parameter 'phase' of type double.");
		return null;
	}

}
