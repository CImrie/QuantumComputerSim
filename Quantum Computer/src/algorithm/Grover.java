package algorithm;
import gate.Hadamard;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import core.Complex;
import core.Matrix;
import core.Qubit;
import core.Register;
import core.State;

/**
 * Class representing Grover's algorithm
 */
public class Grover {
	private double[] values;
	private Register r;
	private int index;
	private FileWriter writer;
	private BufferedWriter buffer;
	private File file = new File("grover.dat");

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

		values = new double[noOfTimesToAct];
		for (int i = 0; i < noOfTimesToAct; i++){
			this.r = this.groverStep();
			double val = r.getProb(index);
			values[i] = val;
		}
		openWriter();
		logValues();
		closeWriter();
		return this.r;
	}
	
	/**
	 * Open filewriter
	 */
	private void openWriter() {
		try {
			writer = new FileWriter(file);
			buffer = new BufferedWriter(writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Closes filewriter
	 */
	private void closeWriter() {
		try {
			writer.close();
			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Outputs values to a file
	 */
	private void logValues() {
		String out = "";

		for (double d : values) {
			out += d + "\r\n";
		}
		try {
			buffer.write(out);
			buffer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Takes a step in Grover's algorithm
	 * @return the resulting register after the step
	 */
	public Register groverStep(){
		Hadamard h = new Hadamard();

		Matrix inverter = Matrix.identity(this.r.getRowLength());
		inverter.setElement(new Complex(-1), 0, 0);

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
	public static void main(String[] args){

		int numberOfQubits = 9;
		int searchIndex = 4;
		long start = System.currentTimeMillis();

		Qubit[] qubits = new Qubit[numberOfQubits];
		for(int i = 0; i < numberOfQubits; i++){
			qubits[i] = new Qubit(new State(0));
		}

		Register testR = new Register(qubits);
		Grover g = new Grover(testR, searchIndex);
		testR = g.act();

		long end = System.currentTimeMillis();
		long duration = end - start;
	}

	/**
	 * Gets the current array of probabilities for the chosen index
	 * @return the array of probabilities
	 */
	public double[] getValues() {
		return values;
	}

}
