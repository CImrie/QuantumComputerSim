package gate;
import core.*;

/**
 * Class representing a controlled phase gate. The controlled phase gate is a 2-qubit gate.
 */
public class ControlledPhase extends TwoQubitGate {
	
	/**
	 * Constructor for a phase gate
	 * @param phase the phase of the gate
	 */
	public ControlledPhase(double phase){
		Matrix m = Matrix.identity(4);
		m.setElement(new Complex(Math.cos(phase), Math.sin(phase)), 3, 3);
		this.matrix = m;
	}
	
	/**
	 * Main Method to test a controlled phase gate.
	 * @param args
	 */
	public static void main(String[] args){
		ControlledPhase gate = new ControlledPhase(Math.PI/2);
		
		Qubit[] qubits = {
				new Qubit(new State(1)),
				new Qubit(new State(0))
		};
		Register r = new Register(qubits);
		
		r = gate.actOn(r);
		System.out.println(r);
	}
	

}
