package gate;

import core.*;

/**
 * Class representing a one-qubit gate.
 */
public class OneQubitGate {
	protected Matrix matrix;

	/**
	 * Empty constructor for a one qubit gate
	 */
	public OneQubitGate() {
	}
	
	/**
	 * Acts the gate on an individual qubit
	 * @param q the qubit to act on
	 * @return the resulting qubit after being acted on by the gate
	 */
	public Qubit actOn(Qubit q) {
		Qubit[] qubits = { q };
		Register r = new Register(qubits);
		r = this.actOn(r, 0);
		Qubit newQ = new Qubit(new Matrix(r.getElements()));
		return newQ;
	}

	/**
	 * Acts the gate on a specific qubit in the register
	 * @param r the register
	 * @param qubitIndex the qubit to act on
	 * @return the resulting register after acting on a specific qubit in the original register
	 */
	public Register actOn(Register r, int qubitIndex) {
		int rSize = r.getLength();
		if (qubitIndex >= rSize)
			throw new RuntimeException("Register incorrect size. Register has " + rSize + " qubits");
		Matrix m = new Matrix(1);
		m.setElement(new Complex(1), 0, 0);
		for (int i = 0; i < rSize; i++) {
			if (i == qubitIndex) {
				m = this.matrix.getTensorProduct(m);
			} else {
				m = Matrix.identity(2).getTensorProduct(m);
			}
		}
		m = m.mult(r);
		return new Register(m);
	}

	/**
	 * Acts the gate on an entire register
	 * @param r the register to act the gate on
	 * @return the resulting register after being acted on by the gate
	 */
	public Register actOn(Register r) {
		int rSize = r.getLength();
		Matrix m = new Matrix(1);
		m.setElement(new Complex(1), 0, 0);
		for (int i = 0; i < rSize; i++) {
			m = this.matrix.getTensorProduct(m);
		}
		m = m.mult(r);
		return new Register(m);
	}
	
}
