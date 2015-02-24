package core;
// @author Ben Crabbe
class Qubit extends Complex {

    private Complex up, down;

    public Qubit() { 

	Complex up = new Complex(0.0, 0.0);
	Complex down = new Complex(0.0,0.0);
	this.setQubit(up, down);

    }
    public Qubit (Qubit original) {

	this.setQubit(original.getUp(), original.getDown()); 

    }

    public Qubit (Complex up, Complex down) { 

	this.setQubit(up, down);
	if (up.normSquared() + down.normSquared() < 0.9999) { System.out.printf("Qubit not normalised!\n");

	}    

    }

    public static Qubit NormQubit(Qubit original) {

	Complex up = original.getUp();
	Complex down = original.getDown();

	Complex Up = divide(up, (up.normSquared() + down.normSquared()));
	Complex Down = divide(down, (up.normSquared() + down.normSquared()));

	return new Qubit(Up, Down);
    }


    public void setQubit(Complex up, Complex down) { 

	this.setUp(up);
	this.setDown(down);

    }

    public void setUp(Complex up) { this.up = up; }
    public void setDown(Complex down) { this.down = down; }

    public Complex getUp() { return this.up; }
    public Complex getDown() { return this.down; }



    public String toString() {

	Complex up = this.getUp();
	Complex down = this.getDown();

	return "(" + up + ")| 0 > + (" + down + ")| 1 >" ;
    }

    public static Qubit add(Qubit a, Qubit b) {

	Complex up = add(a.getUp(), b. getUp());
	Complex down = add(a.getDown(), b.getDown());

	return new Qubit(up, down);

    }

    public static Qubit subtract(Qubit a, Qubit b) {

	Complex up = subtract(a.getUp(), b.getUp());
	Complex down = subtract(a.getDown(), b.getDown());

	return new Qubit(up, down);
    }
}

