package core;

public class ListTest {

	public static void main(String[] args) {
		

				
				ListQubit[] qubits = new ListQubit[2];
				qubits[0] = new ListQubit(new ListState(0));
				qubits[1] = new ListQubit(new ListState(1));
				
				ListRegister r = new ListRegister(qubits);
				
				//Hadamard h = new Hadamard();
				//r = h.actOn(r);
				
				System.out.println(r.makeString());
				
			}
		
	}

