package core;

// @author Ben Crabbe
public class Complex {

	private double realPart;
	private double imagPart;

	// Constructor

	public Complex() {
		this.setComplex(Double.NaN, Double.NaN);
	}

	public Complex(Complex original) {

		this.setComplex(original.getRealPart(), original.getImagPart());

	}

	public Complex(double real, double imag) {

		this.setComplex(real, imag);

	}

	public void setComplex(double real, double imag) {

		this.setRealPart(real);
		this.setImagPart(imag);

	}

	// Setters
	public void setRealPart(double real) {
		this.realPart = real;
	}

	public void setImagPart(double imag) {
		this.imagPart = imag;
	}

	// Getters
	public double getRealPart() {
		return this.realPart;
	}

	public double getImagPart() {
		return this.imagPart;
	}

	public String toString() {

		double real = this.getRealPart();
		double imag = this.getImagPart();

		if (imag >= 0.0) {
			return "(" + real + " + " + imag + "i)";

		} else {

			return "(" + real + " - " + Math.abs(imag) + "i)";

		}
	}

	// Calculate Square Modulus
	public double normSquared() {

		return this.getRealPart()*this.getRealPart() + this.getImagPart()*this.getImagPart();

	}

	// Calculate Modulus
	public double getNorm() {
		return Math.sqrt(this.normSquared());
	}

	// Conjugate
	public Complex conj() {

		return new Complex(this.getRealPart(), -this.getImagPart());

	}

	// static methods
	public Complex add(Complex b) {

		return new Complex(this.getRealPart() + b.getRealPart(), this.getImagPart()
				+ b.getImagPart());

	}

	public Complex subtract(Complex b) {

		return new Complex(this.getRealPart() - b.getRealPart(), this.getImagPart()
				- b.getImagPart());

	}

	public Complex multiply(Complex b) {

		return new Complex(this.getRealPart() * b.getRealPart() - this.getImagPart()
				* b.getImagPart(), this.getRealPart() * b.getImagPart()
				+ this.getImagPart() * b.getRealPart());

	}

	public static Complex multiply(Complex a, double b) {

		return new Complex(a.getRealPart() * b, a.getImagPart() * b);

	}

	public static Complex divide(Complex a, double b) {

		return new Complex(a.getRealPart() / b, a.getImagPart() / b);

	}

	// public static Complex divide(Complex a, Complex b) {

	// return divide(multiply(a,b.conj()), b.

}
