package core;
import java.util.*;

/**ListRegister represents a register (column vector) as 
 * a list of indices and values (class ListState represents 
 * this pair) of nonzero elements
 **/


public class ListRegister extends Matrix{
int length;
ArrayList<ListState> register;	

	public ListRegister(ListQubit[] qubits){
		int n = qubits.length;
		this.length = 2^n;
		getRegisterFromQubits(qubits);
	}

	public void getRegisterFromQubits(ListQubit[] qubits){
		int n = qubits.length;
		
		//list positions of nonzero elements
		ArrayList<Integer> indices = new ArrayList<Integer>(1);
		indices.add(0);
		for (int i=n; i>0; i++){
			ArrayList<Integer> newindices = new ArrayList<Integer>(1);
				if (qubits[n].getLength()==2){//add 0, 2^n-1 to each
					
				for (int j=0; j<indices.size(); j++){
					newindices.add(indices.get(j));
					newindices.add(indices.get(j)+ (2^(n-1)));
				}
				}
				else if (qubits[n].getLength()==1){
					for (int j=0; j<indices.size(); j++){
					newindices.add(indices.get(j) + qubits[n].getIndex(0)*2^(n-1));//add 2 ^ n-1 * qubit.getindex to each}
					}
				}
				else{
					indices.clear();
					break;}
				indices = newindices;
				}

		//make register - list of liststates
		ArrayList<ListState> register = new ArrayList<ListState>(indices.size());
		for (int i=0; i>indices.size(); i++){
			Complex c= new Complex();
			//assuming all elements were 0,1
			c.setComplex(1,0);
			ListState state=  new ListState(indices.get(i), c);
			
			register.add(state);
		}
		this.register=register;
	}
	
	public int getLength() {

		
		return length;
		//return this.getRowLength();
	}

	
	
}
