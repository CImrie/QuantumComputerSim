package core;
// @author Ben Crabbe
public class Matrix {
	
	private double[][] elements;

	public Matrix(double[][] elements){
		this.elements = elements;
	}
	
	public int getRowLength(){
		return this.elements.length;
	}
	
	public int getColLength(){
		if (this.elements.length > 0){
			return this.elements[0].length;
		}
		else {
			return 0;
		}
	}
	
	public double getElement(int row, int col){
		return this.elements[row][col];
	}
	// class containing the methods required for matrix calculations

	    //Print the matrix in row/col format on the terminal
	    static void Print(Matrix grid) {
		for(int r=0; r<grid.getRowLength(); r++) {
		    for(int c=0; c<grid.getColLength(); c++)
			System.out.print(grid.getElement(r,c) + " ");
		    System.out.println();
		}
	    }
	    //Take the tensor product of two matrices
	    public Matrix getTensorProduct(Matrix B) {

		int rowA = this.getRowLength();
		int colA = this.getColLength();
		int rowB = B.getRowLength();
		int colB = B.getColLength();

		double[][] out = new double[rowA*rowB][colA*colB];

		for (int i = 0; i < rowA; i++) {

		    int rowO = i*rowB;

		    for (int j = 0; j < colA; j++) {

			int colO = j*colB;
			double aij = this.elements[i][j];

			for (int k = 0; k < rowB; k++) {
			    for (int l = 0; l < colB; l++) {

				out[rowO+k][colO+l] = aij*B.getElement(k, l);
			    }
			}
		    }
		}
		return new Matrix(out);

	    }
	    //Create an nxn identity matrix given an nxn matrix
	    public static Matrix Iden(double[][] A) {

		int row = A.length;
		int column =A[0].length;

		double[][] Iden = new double[row][column];

		for (int i=0; i < row; i++) {
		    for (int j = 0; j < column; j++) {

			if (i == j) { Iden[i][j] = 1.0; }
			else { Iden[i][j] = 0.0; }

		    }
		}

		return new Matrix(Iden);
	    }
	    
	    public static Matrix trans(double[][] A) {

		int column = A.length;
		int row = A[0].length;

		double[][] B = new double[row][column];

		for( int i = 0; i < column; i++) 
		    for( int j = 0; j < row; j++) 

			B[j][i] = A[i][j];
	      
		return new Matrix(B);
	    }
	    // Add two same dimensional matrices C = A + B
	    public static Matrix add(double[][] a, double[][] b) {

		int row = a.length;
		int column = a[0].length;

		if( row != b.length || column != b[0].length) throw new RuntimeException ("Wrong dimensions");

		double[][] c = new double[row][column];
		
		for(int i = 0; i < row; i++) 
		    for(int j = 0; j < column; j++) 

			c[i][j] = a[i][j] + b[i][j];

		return new Matrix(c);
	    }
	    // Subtract two same dimensional matrices C = A - B
	public static Matrix subtract(double[][] a, double[][] b) {

		int row = a.length;
		int column = a[0].length;
		
		if( row != b.length || column != b[0].length) throw new RuntimeException ("Wrong dimensions");

		double[][] c = new double[row][column];

		for(int i = 0; i < row; i++) 
		    for(int j = 0; j < column; j++) 

			c[i][j] = a[i][j] - b[i][j];

		return new Matrix(c);
	    }

	public static Matrix mult(Matrix A, Matrix B) {
	
	        int rowA = A.getRowLength();
	        int columnA = A.getColLength();
	        int rowB = B.getRowLength();
	        int columnB = B.getColLength();
	        
	        if (columnA != rowB) throw new RuntimeException("Illegal matrix dimensions.");
	        double[][] C = new double[rowA][columnB];
	        for (int i = 0; i < rowA; i++)
	            for (int j = 0; j < columnB; j++)
	                for (int k = 0; k < columnA; k++)
	                    C[i][j] += (A.getElement(i, k) * B.getElement(k, j));
	        return new Matrix(C);
	    }

	    // y = A*x
	public static double[] mult(Matrix A, double[] x) {
		
	        int row = A.getRowLength();
	        int column = A.getColLength();
	        
	        if (x.length != column) throw new RuntimeException("Illegal matrix dimensions.");
	        
	        double[] y = new double[row];
	        for (int i = 0; i < row; i++)
	            for (int j = 0; j < column; j++)
	                y[i] += (A.getElement(i, j) * x[j]);
	        return y;
	    }

	    // y = x^T * A
	public static double[] mult(double[] x, Matrix A) {
		
	        int row = A.getRowLength();
	        int column = A.getColLength();
	        
	        if (x.length != row) throw new RuntimeException("Illegal matrix dimensions.");
	        
	        double[] y = new double[column];
	        for (int j = 0; j < column; j++)
	            for (int i = 0; i < row; i++)
	                y[j] += (A.getElement(i, j) * x[i]);
	        return y;
	    }
}