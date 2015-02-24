package core;
/**The State class represents a linear superposition of qubits
 * @author Connor Imrie
 * 
 **/
public class State {
	double magnitude;
	Complex a;
	Complex b;
	
	public State(Complex a, Complex b){
		this.a = a;
		this.b = b;
		this.normalise();
	}
	
	/**
	 * normalise() manipulates the current qubit coefficients and ensures they are normalised.
	 * If the qubits are already normalised then they are not affected by this.
	 */
	public void normalise(){
		this.magnitude = Math.sqrt(a.getNorm()*a.getNorm() + b.getNorm()*b.getNorm());
	}

	public Matrix tensorProduct(Matrix matrix) {
		Matrix me = this.getMatrix();
		return me.getTensorProduct(matrix);
	}

	public Matrix getMatrix() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Complex get0(){
		return this.a;
	}
	
	public Complex get1(){
		return this.b;
	}
	
	public double getMagnitude(){
		return this.magnitude;
	}
	
}
