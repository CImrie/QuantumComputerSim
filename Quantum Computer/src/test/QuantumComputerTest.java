package test;

import static org.junit.Assert.*;

import org.junit.Test;

import algorithm.Grover;
import core.Complex;
import core.Matrix;
import core.Qubit;
import core.Register;
import core.State;

public class QuantumComputerTest {
	
	@Test
	public void matrixTest(){
		Matrix A = new Matrix(2);
		A.setElement(new Complex(1), 0, 0);
		A.setElement(new Complex(1), 1, 1);
		Matrix B = new Matrix(A.getElements());
		A.mult(B);
		Matrix expectedMatrix = new Matrix(2);
		expectedMatrix.setElement(new Complex(1), 0, 0);
		expectedMatrix.setElement(null, 0, 1);
		expectedMatrix.setElement(null, 1, 0);
		expectedMatrix.setElement(new Complex(1), 1, 1);
		assertEquals(A,expectedMatrix);
	}

	@Test
	public void test() {
		int numberOfQubits = 3;
		int searchIndex = 4;
		double expected = (121.0/128.0);
		
		Qubit[] qubits = new Qubit[numberOfQubits];
		for(int i = 0; i < numberOfQubits; i++){
			qubits[i] = new Qubit(new State(0));
		}
		
		Register testR = new Register(qubits);
		Grover g = new Grover(testR, searchIndex);
		testR = g.act();
		double probAtIndex = testR.getProb(searchIndex);
			
		assertEquals(probAtIndex,expected,1E-5);
	}
	
	@Test
	public void test2() {
		int numberOfQubits = 4;
		int searchIndex = 12;
		double expected = Math.pow((251.0/256.0),2);
		
		Qubit[] qubits = new Qubit[numberOfQubits];
		for(int i = 0; i < numberOfQubits; i++){
			qubits[i] = new Qubit(new State(0));
		}
		
		Register testR = new Register(qubits);
		Grover g = new Grover(testR, searchIndex);
		testR = g.act();
		double probAtIndex = testR.getProb(searchIndex);
			
		assertEquals(probAtIndex,expected,1E-5);
	}

}
