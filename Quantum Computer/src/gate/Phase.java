package gate;
import core.*;

public class Phase extends OneQubitGate implements FOneQubitGate{
 double phase;
 
	public Phase(double phase) {
		Matrix p = new Matrix(2);
		Complex c1 = new Complex(1);
		Complex c0 = new Complex(0);
		Complex c4 = new Complex(Math.cos(phase), Math.sin(phase));
			p.setElement(c1, 0, 0);
			p.setElement(c0, 0, 1);
			p.setElement(c0, 1, 0);
			p.setElement(c4, 1, 1);
			this.matrix = p;
			this.phase=phase;
			}
			
			//functional methods
			public ListRegister actOn(ListRegister r, int qubitIndex) {return r;}	
			public ListQubit actOn(ListQubit q) {
				ListQubit newq= new ListQubit();
				for (int i=0; i < q.getLength(); i++){//states in qubit
				if (q.getqubit().get(i).getIndex() == 1){ 		
				Complex newc = q.getqubit().get(i).getValue().multiply( new Complex(Math.cos(phase), Math.sin(phase)));
		ListState newstate= new ListState(1, newc);
		newq= q;
				newq.setqubit(i, newstate);	
			}
			}	
			return newq;	
		}
			public ListRegister actOn(ListRegister r) {return r;}
		
	/**
	 * This is a test main method to check that Phase Gate gives appropriate state output.
	 * @param args
	 */
	public static void main(String[] args){
		Qubit[] q = new Qubit[1];
		q[0] = new Qubit(new State(1));
		
		Register r = new Register(q);
	Phase p = new Phase(Math.PI/4);
		r = p.actOn(r);

		System.out.println(r.toString());
		ListQubit lq = new ListQubit(new Complex(0,0), new Complex (1,0));
		
		ListRegister a= new ListRegister(new ListQubit[] { lq });
		
		ListQubit result= p.actOn(lq);
		System.out.println("result (nonzero elements):" );
		//should be for pi/4:  {.707, .707}
		for (int i=0; i < result.getLength(); i++){
			System.out.println(result.getqubit().get(i).getIndex() + ": " + result.getqubit().get(i).getValue().getRealPart()+ "+ " +result.getqubit().get(i).getValue().getImagPart());
			}
	}

}

