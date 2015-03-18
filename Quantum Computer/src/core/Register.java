package core;
/**The Register class represents a quantum register that contains 'n' qubits 
 * @author Connor Imrie
 * 
 * The register is stored as an array of states. 
 * These quantum qubits are a superposition of states and handle their own behaviour 
 * relating to normalisation etc.
 * 
 * To get a meaningful result out of the register, 
 * each element must be taken by the tensor product of the element to its 'right' 
 * in the array (i.e. counting down the array)
 **/
public class Register extends Matrix {
	
	/**
	 * Constructor for a register using another matrix
	 * @param m the matrix used to construct the register
	 */
	public Register(Matrix m){
		super(m);
	}

	/**
	 * Constructor for a register using an array of Qubits
	 * @param qubits the array of Qubits used to construct the register
	 */
	public Register(Qubit[] qubits){
		this.setElements(this.getRegisterFromQubits(qubits).getElements());
	}

	/**
	 * Gets the length of a register
	 * @return the length of a register
	 */
	public int getLength() {
		return (int)(Math.log(this.getRowLength()) / Math.log(2));
	}

	/**
	 * Gets the tensored matrix from an array of Qubits
	 * @param qubits the array of Qubits
	 * @return the matrix of Qubits tensored together
	 */
	public Matrix getRegisterFromQubits(Qubit[] qubits){
		//go through each state in the array and take the tensor product with the element to its right:
		int length = qubits.length;
		//start with the last two elements:
		Matrix currentTensorMatrix = new Matrix(1);
		currentTensorMatrix.setElement(new Complex(1), 0, 0);
		//Then loop through the remaining elements and take the tensor product with a matrix
		for (int i = 0; i < length ; i++){
			currentTensorMatrix = currentTensorMatrix.getTensorProduct(qubits[i]);
		}
		return currentTensorMatrix;
	}
	
	
}
