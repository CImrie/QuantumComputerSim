package gate;
import core.*;

public class Phase implements Gate{

	@Override
	public State actOn(State s) {
		//ensure the state has only one qubit (no superposition):
		if (s.get0() > 0 && s.get1() > 0){
			try {
				throw new Exception("State given to Hadamard is not a single qubit. Only a single qubit can be accepted");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//check coefficients to each qubit
		if (s.get0() > 0){
			return (new State(1, 0));
		}
		else if(s.get1() > 0){
			return (new State(0,1));
		}
		return null;
	}
	
	/**
	 * This is a test main method to check that hadamard gives appropriate state output.
	 * @param args
	 */
	public static void main(String[] args){
		Phase p = new Phase();
		State newS = p.actOn(new State(1, 0));
		System.out.println(newS.get0() + "|0> " + newS.get1() + "|1> ");
	}

}
