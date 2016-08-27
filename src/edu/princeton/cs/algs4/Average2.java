package edu.princeton.cs.algs4;

import java.util.Scanner;

public class Average2 {
	public static void main(String[] args) {
		int count = 0;
		double sum = 0;
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			sum += scanner.nextDouble();
			count++;
		}
		StdOut.println(sum/count);
	}
}
