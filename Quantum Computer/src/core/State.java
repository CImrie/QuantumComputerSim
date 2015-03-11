package core;

// @author Ben Crabbe
public class State extends Matrix{

public State(Matrix m) {
	if (m.getRowLength() == 2 && m.getColLength() == 1){
		this.setElements(m.getElements());
	}
	new Exception("THATS NOT A QUBIT");
	//super(m);
}
	
	/**
	 * Creates a |0> or |1> qubit 
	 */
	public State(int type){
		this.elements = new Complex[2][1];
		if (type == 0){
			this.elements[0][0] = new Complex(1);
			this.elements[1][0] = new Complex(0);
		}
		else if (type == 1){
			this.elements[0][0] = new Complex(0);
			this.elements[1][0] = new Complex(1);
		}
	}

//	@Override
//	public String toString() {
//		int a = this.get0();
//		int b = this.get1();
//
//		String s = "";
//		if (a > 0){
//			if (a > 1){
//				s += "(" + a + ")| 0 >";
//			}
//			else {
//				s += "| 0 >";
//			}
//		}
//		if (a > 0 && b > 0){
//			s += " + ";
//		}
//		if (b > 0){
//			if (b > 1){
//				s += "(" + b + ")| 1 >";
//			}
//			else {
//				s += "| 1 >";
//			}
//		}
//		return s;
//	}
//	
	public Complex get0() {
		return this.elements[0][0];
	}
	
	public Complex get1() {
		return this.elements[1][0];
	}
	/**
	 * Returns the integer value corresponding to whether the qubit is a |0> or |1> qubit
	 */
	public int getStateType(){
		if (this.getElement(0,0) == new Complex(1)){
			return 0;
		}
		else if (this.getElement(1,0) == new Complex(1)){
			return 1;
		}
		else {
			new Exception("Qubit is not properly formed. Can only have 1 integer component. Q = " + this.toString());
		}
		return 0;
	}
	public Matrix getMatrix() {
		Matrix m = new Matrix(2,1);
		m.setElements(this.getElements());
		return m;
	}
	
public static void main(String[] args){
	State q = new State(0);
	System.out.println(q);

}

	
}
