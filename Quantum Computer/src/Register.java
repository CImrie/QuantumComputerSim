/**The Register class represents a quantum register that contains 'n' qubits 
 * @author Connor Imrie
 * 
 * The register is stored as an array of states. 
 * These quantum states are a superposition of qubits and handle their own behaviour 
 * relating to normalisation etc.
 * 
 * To get a meaningful result out of the register, 
 * each element must be taken by the tensor product of the element to its 'right' 
 * in the array (i.e. counting down the array)
 **/
public class Register {
	State[] states;
	
	public Register(int n){
		this.states = new State[n];
	}
}
