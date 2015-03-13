package core;

import gate.Hadamard;

public class main {
	public static void main(String[] args){
		
		Qubit[] qubits = new Qubit[2];
		qubits[0] = new Qubit(new State(0));
		qubits[1] = new Qubit(new State(1));
		
		Register r = new Register(qubits);
		
		Hadamard h = new Hadamard();
		r = h.actOn(r);
		
		System.out.println(r.toString());
		//System.out.println(r.getQubit(0).prob1());
	}
}
