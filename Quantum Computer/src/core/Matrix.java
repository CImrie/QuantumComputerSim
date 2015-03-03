package core;

public class Matrix {
	
	private Complex[][] elements;

	public Matrix(Complex[][] elements){
		this.elements = elements;
	}
	
	public Matrix(int rows, int columns){
		this.elements = new Complex[rows][columns];
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
	
	public Complex getElement(int row, int col){
		return this.elements[row][col];
	}
	
	public void SetElement(Complex val, int row, int col){
		this.elements[row][col] = val;
	}
	// class containing the methods required for ComplexMatrix calculations

	    //Print the ComplexMatrix in row/col format on the terminal
	    static void Print(Matrix grid) {
		for(int r=0; r<grid.getRowLength(); r++) {
		    for(int c=0; c<grid.getColLength(); c++)
			System.out.print(grid.getElement(r,c) + " ");
		    System.out.println();
		}
	    }

	    
	    /**
	     * Gets the tensor product with another matrix (Complex Version)
	     * @param matrix ComplexMatrix B
	     * @return 
	     */
	    public Matrix getTensorProduct(Matrix matrix) {
		int rowA = this.getRowLength();
		int colA = this.getColLength();
		int rowB = matrix.getRowLength();
		int colB = matrix.getColLength();

		Complex[][] out = new Complex[rowA*rowB][colA*colB];

		for (int i = 0; i < rowA; i++) {

		    int rowO = i*rowB;

		    for (int j = 0; j < colA; j++) {

			int colO = j*colB;
			Complex aij = this.elements[i][j];

			for (int k = 0; k < rowB; k++) {
			    for (int l = 0; l < colB; l++) {

				out[rowO+k][colO+l] = aij.multiply(matrix.getElement(k, l));
			    }
			}
		    }
		}
		return new Matrix(out);

	    }
	    
	    //Create an nxn identity ComplexMatrix given an nxn matrix
	    public static Matrix Iden(Complex[][] A) {

		int row = A.length;
		int column =A[0].length;

		Complex[][] Iden = new Complex[row][column];

		for (int i=0; i < row; i++) {
		    for (int j = 0; j < column; j++) {

			if (i == j) { Iden[i][j] = new Complex(1.0,0.0); }
			else { Iden[i][j] = new Complex(0.0,0.0); }

		    }
		}

		return new Matrix(Iden);
	    }
	    
	    public static Matrix trans(Complex[][] A) {

		int column = A.length;
		int row = A[0].length;

		Complex[][] B = new Complex[row][column];

		for( int i = 0; i < column; i++) 
		    for( int j = 0; j < row; j++) 

			B[j][i] = A[i][j];
	      
		return new Matrix(B);
	    }
	    // Add two same dimensional matrices C = A + B
	    public static Matrix add(Complex[][] a, Complex[][] b) {

		int row = a.length;
		int column = a[0].length;

		if( row != b.length || column != b[0].length) throw new RuntimeException ("Wrong dimensions");

		Complex[][] c = new Complex[row][column];
		
		for(int i = 0; i < row; i++) 
		    for(int j = 0; j < column; j++) 

			c[i][j] = a[i][j].add(b[i][j]);

		return new Matrix(c);
	    }
	    // Subtract two same dimensional matrices C = A - B
	public static Matrix subtract(Complex[][] a, Complex[][] b) {

		int row = a.length;
		int column = a[0].length;
		
		if( row != b.length || column != b[0].length) throw new RuntimeException ("Wrong dimensions");

		Complex[][] c = new Complex[row][column];

		for(int i = 0; i < row; i++) 
		    for(int j = 0; j < column; j++) 

			c[i][j] = a[i][j].subtract(b[i][j]);

		return new Matrix(c);
	    }

	public static Matrix mult(Matrix A, Matrix B) {
	
	        int rowA = A.getRowLength();
	        int columnA = A.getColLength();
	        int rowB = B.getRowLength();
	        int columnB = B.getColLength();
	        
	        if (columnA != rowB) throw new RuntimeException("Illegal ComplexMatrix dimensions.");
	        Complex[][] C = new Complex[rowA][columnB];
	        for (int i = 0; i < rowA; i++)
	            for (int j = 0; j < columnB; j++)
	                for (int k = 0; k < columnA; k++)
	                    C[i][j] = C[i][j].add((A.getElement(i, k).multiply(B.getElement(k, j))));
	        return new Matrix(C);
	    }

	    // y = A*x
	public static Complex[] mult(Matrix A, Complex[] x) {
		
	        int row = A.getRowLength();
	        int column = A.getColLength();
	        
	        if (x.length != column) throw new RuntimeException("Illegal ComplexMatrix dimensions.");
	        
	        Complex[] y = new Complex[row];
	        for (int i = 0; i < row; i++)
	            for (int j = 0; j < column; j++)
	                y[i] = y[i].add((A.getElement(i, j).multiply(x[j])));
	        return y;
	    }

	    // y = x^T * A
	public static Complex[] mult(Complex[] x, Matrix A) {
		
	        int row = A.getRowLength();
	        int column = A.getColLength();
	        
	        if (x.length != row) throw new RuntimeException("Illegal ComplexMatrix dimensions.");
	        
	        Complex[] y = new Complex[column];
	        for (int j = 0; j < column; j++)
	            for (int i = 0; i < row; i++)
	                y[j] = y[j].add((A.getElement(i, j).multiply(x[i])));
	        return y;
    }
	
	public String toString(){
		String str = "";
		for(int i = 0; i < this.getRowLength(); i++){
			if (i == 0){
				//str = "[";
			}
			for (int j = 0; j < this.getColLength(); j++){
				str += this.getElement(i, j).toString();
			}
			str += "\n";
		}
		
		return str;
	}
}