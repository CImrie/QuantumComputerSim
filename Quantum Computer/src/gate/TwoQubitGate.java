package gate;
import core.*;

/**
 * Class representing a two qubit gate.
 */
public class TwoQubitGate {
	protected Matrix matrix;
	
	/**
	 * Acts the gate on an entire register
	 * @param r the register to act the gate on
	 * @return the resulting register after being acted on by the gate
	 */
	public Register actOn(Register r){
		if(r.getLength() % 2 == 0){
			Matrix m = new Matrix(1);
			m.setElement(new Complex(1), 0, 0);
			for (int i = 0; i < r.getLength()/2; i++){
				m = this.matrix.getTensorProduct(m);
			}
			return new Register(m.mult(r));
		}
		else {
			new Exception("Method: actOn(Register r) -> Pair(s) of Qubits must be given to two qubit gate, '" + r.getLength() + "' Qubits were given");
		}
		return null;
	}
	
	/**
	 * Acts the gate on a specific pair of qubits in the register
	 * @param r the register
	 * @param pairIndex the index of the pair of qubits within the register
	 * @return the resulting register after acting the gate on a pair of qubits in the original register
	 */
	public Register actOn(Register r, int pairIndex){
		if(r.getLength() % 2 == 0){
			int rSize = r.getLength();
			if (pairIndex >= rSize){
				throw new RuntimeException("Register incorrect size. Register has " + rSize + " qubits");
			}
			Matrix m = new Matrix(1);
			m.setElement(new Complex(1), 0, 0);
			for (int i = 0; i < rSize/2; i++) {
				if (i == pairIndex) {
					m = this.matrix.getTensorProduct(m);
				} else {
					m = Matrix.identity(4).getTensorProduct(m);
				}
			}
			m = m.mult(r);
			return new Register(m);
		}
		else {
			new Exception("Method: actOn(Register r, int qubitIndex) -> Pair(s) of Qubits must be given to two qubit gate, '" + r.getLength() + "' Qubits were given");
		}
		return null;
	}

}
