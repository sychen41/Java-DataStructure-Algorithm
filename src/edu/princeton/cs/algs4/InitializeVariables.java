/* Reference: https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html */
package edu.princeton.cs.algs4;

import java.util.Random;

public class InitializeVariables {
	private static Random random = initializeClassVariable();
	private static long seed; 
	private int uselessInstanceVariable1;
	private int[] uselessInstanceVariable2 = initializeInstanceVariable();
	private int uselessInstanceVariable3;
	
	// two alternative ways to initialize class variables.
	// (instead of doing it when declaring. e.g. private static long seed = blabla...)
	static {
		seed = System.currentTimeMillis();
	}
	
	private static Random initializeClassVariable() {
		return new Random(seed);
	}
	
	// two alternative ways to initialize instance variables.
	// (instead of doing it when declaring. e.g. private int uselessInstanceVariable1 = 1;) 
	{
		uselessInstanceVariable1 = 1;
	}
	// need "final" because calling non-final methods during instance initialization can cause problems.
	private final int[] initializeInstanceVariable() {
		int n = 10;
		int[] temp = new int[n];
		for (int i = 0; i < n; i++) {temp[i] = i;}
		return temp;
	}

	public InitializeVariables() {
		uselessInstanceVariable3 = 3;
	}
	public InitializeVariables(int x) {
		uselessInstanceVariable3 = x;
	}
	
	public static void main(String[] args) {
		StdOut.println(seed);
		StdOut.println(random.nextInt());
		InitializeVariables obj1 = new InitializeVariables(123);
		StdOut.println(obj1.uselessInstanceVariable1);
		StdOut.println(obj1.uselessInstanceVariable3);
		for (int i:obj1.uselessInstanceVariable2) {StdOut.print(i + " ");}
		StdOut.println();
	}
}
