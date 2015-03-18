package core;

/**
 * The Qubit class represents a linear superposition of states
 **/
public class Qubit extends Matrix {
	double magnitude;
	
	/**
	 * Constructor for a Qubit, which is a 2x1 matrix
	 */
	public Qubit() {
		super(2,1);
	}
	
	/**
	 * Constructs a Qubit using a 2x1 matrix
	 * @param m the 2x1 matrix used to construct the qubit
	 */
	public Qubit(Matrix m){
		if (m.getRowLength() == 2 && m.getColLength() == 1){
			this.setElements(m.getElements());
		}
		new Exception("THATS NOT A QUBIT");
	}
	
	/**
	 * Sets the Qubit using two complex numbers
	 * @param a the first complex number
	 * @param b the second complex number
	 */
	public Qubit(Complex a, Complex b){
		this.elements = new Complex[2][1];
		this.elements[0][0] = a;
		this.elements[1][0] = b;
		this.normalise();
	}
	
	/**
	 * Constructs a Qubit using a state
	 * @param s the state used to construct the Qubit
	 */
	public Qubit(State s){
		this.setElements(s.getElements());
		this.normalise();
	}
	
	/**
	 * Gets the matrix representing the Qubit
	 * @return the matrix of the Qubit
	 */
	public Matrix getMatrix() {
		Matrix m = new Matrix(2,1);
		m.setElements(this.getElements());
		return m;
	}
	
	/**
	 * normalise() manipulates the current qubit coefficients and ensures they are normalised.
	 * If the qubits are already normalised then they are not affected by this.
	 */
	public void normalise(){
		this.magnitude = Math.sqrt(this.get0().normSquared() + this.get1().normSquared());
		this.setElement(this.get0().divideBy(this.magnitude), 0, 0);
		this.setElement(this.get1().divideBy(this.magnitude), 1, 0);
	}
	
	/**
	 * Gets the first complex number of the Qubit
	 * @return first complex number
	 */
	public Complex get0(){
		return this.getElement(0,0);
	}
	
	/**
	 * Gets the second complex number of the Qubit
	 * @return second complex number
	 */
	public Complex get1(){
		return this.getElement(1,0);
	}
	
	/**
	 * Gets the magnitude of the Qubit
	 * @return the magnitude
	 */
	public double getMagnitude(){
		Complex a = this.elements[0][0];
		Complex b = this.elements[1][0];
		
		double out = a.getNorm() + b.getNorm();
		return out;
	}
	
	/**
	 * Converts a Qubit to a string representation
	 * @return the string representation of a Qubit
	 */
	public String toString() { 
		
		Complex a = this.get0();
		Complex b = this.get1();
		
	return a + "|0> + " + b + "|1>";
		
	}
	
	public State getState(int offset){
		if (offset == 0){
			return new State(0);
		}
		else {
			return new State(1);
		}
	}
		
	
}
