package core;

// @author Ben Crabbe
public class Qubit{

	private int a, b;

	public Qubit(int a, int b){
		this.a = a;
		this.b = b;
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
	
public static void main(String[] args){
	Qubit q = new Qubit(0,1);
	System.out.println(q);
}

	
}
