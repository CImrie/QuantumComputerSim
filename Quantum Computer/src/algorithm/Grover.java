package algorithm;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import gate.Hadamard;
import core.*;

/**
 * Class representing Grover's algorithm
 */
public class Grover {
	private Register r;
	private int index;
	
	/**
	 * Constructs a new Grover object
	 * @param r the register
	 * @param qubitIndex the index to search for
	 */
	public Grover(Register r, int qubitIndex){
		this.index = qubitIndex;	
		//prepare computational basis
		Hadamard h = new Hadamard();
		this.r = h.actOn(r);
	}
	
	/**
	 * Run Grover's algorithm
	 * @return the resulting register after running the algorithm
	 */
	public Register act(){
		int noOfTimesToAct = (int) Math.round((Math.PI/4) * Math.sqrt(Math.pow(2, this.r.getLength())));
		for (int i = 0; i < noOfTimesToAct; i++){
			this.r = this.groverStep();
			//System.out.println(this.r);
		}
		return this.r;
	}
	
	/**
	 * Takes a step in Grover's algorithm
	 * @return the resulting register after the step
	 */
	public Register groverStep(){
		Hadamard h = new Hadamard();
		
		Matrix inverter = Matrix.identity(this.r.getRowLength());
		inverter.setElement(new Complex(-1), 0, 0);
		
		//filter through oracle
		Oracle o = new Oracle(this.r.getRowLength(), this.index);
		this.r = o.actOn(this.r);
		
		Register out = h.actOn(this.r);
		out = new Register(inverter.mult(out));
		out = h.actOn(out);
		return out;
	}
	
	/**
	 * Main method to test Grover class
	 * @param args
	 */
	
	/*
	public static void main(String[] args){
		int numberOfQubits = 3;
		int searchIndex = 0;
		
		
		PrintStream out;
		try {
			out = new PrintStream(new FileOutputStream("output.txt"));
			System.setOut(out);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		Qubit[] qubits = new Qubit[numberOfQubits];
		for(int i = 0; i < numberOfQubits; i++){
			qubits[i] = new Qubit(new State(0));
		}
		
		Register testR = new Register(qubits);
		Grover g = new Grover(testR, searchIndex);
		testR = g.act();
		System.out.println(testR);
		System.out.println(testR.getProb(searchIndex));
	}
	*/

}
