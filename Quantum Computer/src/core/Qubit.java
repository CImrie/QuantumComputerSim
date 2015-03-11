package core;
/**The State class represents a linear superposition of qubits
 * @author Connor Imrie
 * 
 **/
public class Qubit extends Matrix {
	double magnitude;
	
	public Qubit() {
		super(2,1);
	}
	
	public Qubit(Matrix m){
		if (m.getRowLength() == 2 && m.getColLength() == 1){
			this.setElements(m.getElements());
		}
		new Exception("THATS NOT A QUBIT");
		
	}
	
	public Qubit(Complex a, Complex b){
		super(2,1);
		this.setElement(a, 0, 0);
		this.setElement(b, 1, 0);
		this.normalise();
	}

	public Qubit(State q){
		super(2,1);
		super.setElements(q.getElements().clone());
	//	super.setElement(q.getElement(1,0), 1, 0);
		this.normalise();
	}
	
	/**
	 * normalise() manipulates the current qubit coefficients and ensures they are normalised.
	 * If the qubits are already normalised then they are not affected by this.
	 */
	public void normalise(){
		this.magnitude = Math.sqrt(this.get0().getNorm()*this.get0().getNorm() + this.get1().getNorm()*this.get1().getNorm());
		this.setElement(this.get0().divideBy(this.magnitude), 0, 0);
		this.setElement(this.get1().divideBy(this.magnitude), 1, 0);
	}
	
	public Complex get0(){
		return this.getElement(0,0);
	}
	
	public Complex get1(){
		return this.getElement(1,0);
	}
	
	public double getMagnitude(){
		return this.magnitude;
	}
	
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
		
	
	// Method to calculate the probability of a qubit being in either up or down
	public double prob0() {
	
		double prob = 0;

		Complex up = new Complex(this.get0());
		prob = up.normSquared();

		return prob;
	}
	
	public double prob1() {
		double prob = 0;
		
		Complex down = new Complex(this.get1());
		prob = down.normSquared();
		
		return prob;
	}
	
}
