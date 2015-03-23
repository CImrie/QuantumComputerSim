package algorithm;
import core.*;
import gate.Hadamard;

public class Shor {
	public static void main(String[] args) {
		int m = 3;
		int N = 5;

		Register r1 = new Register("0", true, 5);
		Register r2 = new Register("0", true, 5);

		Hadamard h = new Hadamard();
		r1 = h.actOn(r1);
		Matrix tensor = r1.getTensorProduct(r2);

		//System.out.println(tensor);
		Matrix finalMatrix = new Matrix(r2.getRowLength(),1);
		for(int i = 0; i < r2.getRowLength(); i++) {
			int s = (int)(Math.pow(m, i)%N);
			String string = "" + s;
			Register newReg = new Register(string,true, r2.getLength());

			finalMatrix = finalMatrix.add(newReg);
			//	System.out.println(s);
		}
		//		System.out.println(finalMatrix);


		Register out = new Register(r1.getTensorProduct(finalMatrix));
		System.out.println(out);
		Matrix newR = projection(out);
			
	}

	public static Matrix projection(Register r) {

		int noOfQubits = r.getLength();
		int noOfStates = r.getRowLength();
		int random = (int)Math.round(Math.sqrt(noOfStates)*Math.random());
		String string = "" + random;
		Register R = new Register(string, true, noOfQubits/2);
		Register RT = new Register(Matrix.getTranspose(R));
		Matrix projection = R.mult(RT);
		Matrix iden = Matrix.identity((int)Math.sqrt(noOfStates));
		System.out.println(iden);
		Matrix out = projection.getTensorProduct(iden);
		
		return null;
	}

	public static Matrix actOnRegister(Register r) {
		// Create a hadamard matrix of (size register length)/2 and and identity of same length
		/*int sizeOfOneRegister = (int)Math.sqrt(r.getLength());

		Hadamard h = new Hadamard();

		Matrix hadamard = h.getMatrix();
		Matrix finalHadamard = new Matrix(hadamard);
		for(int i = 0; i < sizeOfOneRegister; i++) {
		finalHadamard = finalHadamard.getTensorProduct(hadamard);
		}

		Matrix iden = Matrix.identity((int)Math.sqrt(r.getRowLength()));
		Matrix out = finalHadamard.getTensorProduct(iden);
		//System.out.println(finalHadamard);
		System.out.println("HERE");
		return out.mult(r);*/

		//create hadamard that is sqrt(superimposed register) in size
		int sizeH = r.getLength()/2;
		Hadamard h = new Hadamard();
		Matrix H = h.getMatrix();
		Matrix tempBigH = new Matrix(1);
		tempBigH.setElement(new Complex(1), 0, 0);
		for (int i = 0; i < sizeH; i++){
			tempBigH = tempBigH.getTensorProduct(H);
		}
		H = null;
		Matrix I = Matrix.identity((int)Math.sqrt(r.getRowLength()));
		tempBigH = tempBigH.getTensorProduct(I);
		I = null;
		/*System.out.println(r.getRowLength() + "      " + r.getColLength());
		System.out.println(tempBigH.getRowLength() + "    " + tempBigH.getColLength());
		System.out.println(I.getRowLength() + "      " + I.getColLength());*/
		return tempBigH.mult(r);

	}
}
