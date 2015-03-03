package core;

// @author Ben Crabbe
public class Qubit{

	private int a, b;

	public Qubit(int a, int b){
		this.a = a;
		this.b = b;
	}
	
	/**
	 * Creates a |0> or |1> qubit 
	 */
	public Qubit(int type){
		if (type == 0){
			this.a = 1;
			this.b = 0;
		}
		else if (type == 1){
			this.a = 0;
			this.b = 1;
		}
	}

	@Override
	public String toString() {
		int a = this.get0();
		int b = this.get1();

		String s = "";
		if (a > 0){
			if (a > 1){
				s += "(" + a + ")| 0 >";
			}
			else {
				s += "| 0 >";
			}
		}
		if (a > 0 && b > 0){
			s += " + ";
		}
		if (b > 0){
			if (b > 1){
				s += "(" + b + ")| 1 >";
			}
			else {
				s += "| 1 >";
			}
		}
		return s;
	}
	
	public int get0(){
		return this.a;
	}
	
	public int get1(){
		return this.b;
	}
	
	/**
	 * Returns the integer value corresponding to whether the qubit is a |0> or |1> qubit
	 */
	public int getQubitType(){
		if (this.get0() == 1){
			return 0;
		}
		else if (this.get1() == 1){
			return 1;
		}
		else {
			new Exception("Qubit is not properly formed. Can only have 1 integer component. Q = " + this.toString());
		}
		return 0;
	}

	
public static void main(String[] args){
	Qubit q = new Qubit(0,1);
	System.out.println(q);
}

	
}
