package algorithm;
import core.*;
import gate.*;

/**
 * Class representing the Oracle
 */
public class Oracle extends OneQubitGate {
	
	/**
	 * Constructor for the oracle of a specific size
	 * @param size the size of the oracle to be created
	 * @param index the index to search for
	 */
	public Oracle(int size, int index){
		Matrix m = Matrix.identity(size);
		m.setElement(new Complex(-1), index, index);
		this.matrix = m;
	}

	/**
	 * Acts the oracle on a register
	 * @return the resulting register after acting the oracle on the original matrix
	 */
	public Register actOn(Register r) {
		return new Register(this.matrix.mult(r));
	}
}