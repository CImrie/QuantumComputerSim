package algorithm;
import algorithm.Oracle;
import core.*;
import gate.Hadamard;

public class GroverStep extends Matrix {

	public static Matrix actOn(Register r, int oracleIndex){
		
		Hadamard h = new Hadamard();
		Register r2 = new Register(r);
		Oracle o = new Oracle();
		
		Matrix out = o.actOn(r, oracleIndex).mult(r);

		r = new Register(out);
		r = h.actOn(r);
		out = o.actOn(r2, 0).mult(r);
		r = new Register(out);
		r = h.actOn(r);
		
		return r;
	}


	public static void main(String[] args) {
		Hadamard h = new Hadamard();
		Qubit[] q = new Qubit[4];
		q[0] = new Qubit(new State(0));
		q[1] = new Qubit(new State(0));
		q[2] = new Qubit(new State(0));
		q[3] = new Qubit(new State(0));

		Register r2 = new Register(q);
		r2 = h.actOn(r2);
		
		Matrix C = actOn(r2, 0);
		r2 = new Register(C);
	//	C = actOn(r2, 0);
		r2 = new Register(C);
	//	C = actOn(r2, 0);
		r2 = new Register(C);
	//	C = actOn(r2, 0);
		System.out.println(C);
		System.out.println(C.getProb(0));


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
