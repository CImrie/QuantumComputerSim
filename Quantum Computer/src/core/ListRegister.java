package core;
import java.util.*;
import java.lang.Math;

/**ListRegister represents a register (column vector) as 
 * a list of indices and values (class ListState represents 
 * this pair) of nonzero elements
 **/


public class ListRegister extends Matrix{
int matrixsize;
ArrayList<ListState> register;	
int n;
	public ListRegister(ListQubit[] qubits){
		int n = qubits.length;
		this.n=n;
		this.matrixsize = 2^n;
		getRegisterFromQubits(qubits);
	}

	public int getn() {

		
		return n;
		//return this.getRowLength();
	}
	
	public void getRegisterFromQubits(ListQubit[] qubits){
		int n = qubits.length;
		
		//list positions of nonzero elements
		ArrayList<Integer> indices = new ArrayList<Integer>(1);
		indices.add(0);
		for (int i=(n-1); i>=0; i--){
			//for (int i=0; i<=(n-1); i++){
			ArrayList<Integer> newindices = new ArrayList<Integer>();
		
				if (qubits[i].getLength()==2){//add 0, 2^n-1 to each
					
				for (int j=0; j<indices.size(); j++){
					newindices.add(indices.get(j));
					newindices.add(indices.get(j)+ (2^(i)));
				}
				}
				else if (qubits[i].getLength()==1){
					for (int j=0; j<indices.size(); j++){
					newindices.add(indices.get(j) + (qubits[i].getIndex(0)*(int)(Math.pow(2,i))));
					}
				}
				else{
					indices.clear();
					break;}
				indices = newindices; 
				}

		//make register - list of liststates
		ArrayList<ListState> register = new ArrayList<ListState>(indices.size());
		for (int i=0; i<indices.size(); i++){
			Complex c= new Complex();
			//assuming all elements were 0,1
			c.setComplex(1,0);
			ListState state=  new ListState(indices.get(i), c);
			
			register.add(state);
		}
		this.register=register;
	}
	
	public int getLength() {

		
		return matrixsize;
		//return this.getRowLength();
	}

	public String makeString(){
		String string= "";
		for (int i=0; i<register.size(); i++){
			string = string + ( register.get(i).getIndex() +" : { " + register.get(i).getValue().getRealPart() + ", " 
		 + register.get(i).getValue().getImagPart() + "} \n");

		}
return string;		
	}
	
}
