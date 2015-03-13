package gate;

import core.*;


/**
 * Interface for a one-qubit gate. It takes either a qubit or a qubit and an extra parameter,
 * and returns a state as a result. Example: Hadamard gate.
 * @author Connor Imrie
 *
 */
public interface OneQubitGate {

	public Matrix actOn(Register r, int qubitIndex);

	public Qubit actOn(Qubit q);

	public Qubit actOn(Qubit q, double parameter);

	public Register actOn(Register r);
}
