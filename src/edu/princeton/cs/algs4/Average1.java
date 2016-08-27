package edu.princeton.cs.algs4;

public class Average1 {
	public static void main(String[] args) {
		int count = 0;
		double sum = 0;
		while (!StdIn.isEmpty()) {
			sum += StdIn.readDouble();
			count++;
		}
		StdOut.println(sum/count);
	}
}
