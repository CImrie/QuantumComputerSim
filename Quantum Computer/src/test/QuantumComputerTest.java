package test;

import static org.junit.Assert.*;

import org.junit.Test;

import algorithm.Grover;
import core.Qubit;
import core.Register;
import core.State;

public class QuantumComputerTest {

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
