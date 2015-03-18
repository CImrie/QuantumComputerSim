package gate;
import core.*;

/**
 * The class representing a CNOT gate. The C-NOT gate is a 2-qubit gate.
 */
public class CNOT extends TwoQubitGate{
	
	/**
	 * Constructs a CNOT gate
	 */
	public CNOT(){
		Matrix m = new Matrix(4);
		for(int i = 0; i < m.getRowLength(); i++){
			for(int j =0; j < m.getColLength(); j++){
				if( (i==0 && j==0) || (i==1 && j==1) || (i==2 && j==3) || (i==3 && j==2)){
					m.setElement(new Complex(1), i, j);
				}
				else {
					m.setElement(new Complex(0), i, j);
				}
			}
		}
		this.matrix = m;
	}
	
	/**
	 * Main method to test a CNOT gate
	 * @param args
	 */
	public static void main(String[] args){
		Qubit x = new Qubit(new State(1));
		Qubit y = new Qubit(new State(0));
		Qubit[] qubits = {x, y};
		Register r = new Register(qubits);
		CNOT gate = new CNOT();
		
		r = gate.actOn(r);
		System.out.println(r);
	}
	
}
