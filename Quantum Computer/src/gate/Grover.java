package gate;
import core.*;
import gate.Hadamard;
import gate.Oracle;
/* Class that implements gates to perform the Grover step alogrithm
 * @Author Ben Crabbe
 * */

public class Grover {

	public static Matrix GroverStep(Matrix A) {
		Hadamard h = new Hadamard();
		Register r2 = new Register(2);
		Oracle o = new Oracle();

		r2.setQubit(h.actOn(new Qubit(new State(0))),0);
		r2.setQubit(h.actOn(new Qubit(new State(0))),1);

		//	Matrix h1 = Hadamard.createHadamard(3);
		Matrix H = Hadamard.HadamardTensor(2);

		A = H.mult(A);
		A = o.actOn(r2, 0).mult(A);
		A= H.mult(A);
		return A;
	}

	public static Register turnOn() {

		Hadamard h = new Hadamard();

		Qubit newone = h.actOn(new Qubit(new State(0)));
		Qubit newtwo = h.actOn(new Qubit(new State(0)));

		Register r = new Register(2);
		r.setQubit(newone, 0);
		r.setQubit(newtwo, 1);

		return r;
	}
	public static void main(String[] args) {
		//		
		Oracle o = new Oracle();
		Hadamard h = new Hadamard();
		Register r2 = new Register(2);

		r2.setQubit(h.actOn(new Qubit(new State(0))),0);
		r2.setQubit(h.actOn(new Qubit(new State(0))),1);
	//	Matrix A = new Matrix(4,4);
		Matrix B = o.actOn(r2, 3);
		Matrix A = r2.getMatrix();
		Matrix C = B.mult(A);
		C = GroverStep(C);
		System.out.println(C);


		//		//connor's example
		//		Hadamard h = new Hadamard();
		//		Register r2 = new Register(2);
		//		Qubit q1 = new Qubit(new State(0));
		//		Qubit q2 = new Qubit(new State(0));
		//		r2.setQubit(h.actOn(q1), 0);
		//		r2.setQubit(h.actOn(q2), 1);
		//		
		//		Phase p2 = new Phase();
		//		r2.setQubit(p2.actOn(r2.getQubit(1), Math.PI), 1);
		//		System.out.println(r2.getMatrix());
		//		
		//		r2.setQubit(h.actOn(r2.getQubit(0)), 0);
		//		r2.setQubit(h.actOn(r2.getQubit(1)), 1);
		//		
		//		System.out.println(r2.getMatrix());
		//		
	}
}
