package edu.princeton.cs.algs4;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

	public static long badFibonacci(int n) {
		if (n == 0) return 0;
		else if (n == 1) return 1;
		
		return badFibonacci(n-1) + badFibonacci(n-2);
	}	

	public static long[] f = new long[92];
	public static long topDownFibonacci(int n) {
		if (n == 0) return 0;
		else if (n == 1) return 1;
		
		if (f[n] > 0) return f[n];
		f[n] = topDownFibonacci(n-1) + topDownFibonacci(n-2);
		return f[n];
	}
	
	public static List<Long> fA = new ArrayList<>();
	public Fibonacci(int n) {
		for (int i = 0; i < n+1; i++) fA.add(0L);
	}
	public static long topDownFibonacci2(int n) {
		if (n == 0) return 0;
		else if (n == 1) return 1;
		
		if (fA.get(n) > 0) return fA.get(n);
		fA.set(n, topDownFibonacci(n-1) + topDownFibonacci(n-2));
		return fA.get(n);
	}

	public static void main(String[] args) {
		//StdOut.println(Fibonacci.topDownFibonacci(13));
		//StdOut.println(Fibonacci.topDownFibonacci2(13));
		int fibo = 13;
		Fibonacci f = new Fibonacci(fibo);
		StdOut.println(f.topDownFibonacci2(fibo));
	}
}
