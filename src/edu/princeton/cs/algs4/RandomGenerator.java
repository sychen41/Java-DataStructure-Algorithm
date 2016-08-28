package edu.princeton.cs.algs4;

import java.util.Random;

public final class RandomGenerator {
	private static long seed; 
	private static Random random;
	
	static {
		seed = System.currentTimeMillis();
		random = new Random(seed);
	}
	
	private RandomGenerator() {};
	
	public static int uniform(int n) {
		if (n <= 0) throw new IllegalArgumentException("Parameter N must be positive");
		return random.nextInt(n);
	}

	public static void shuffle(Object[] a) {
        if (a == null) throw new NullPointerException("argument array is null");
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + uniform(n-i);     // between i and n-1
            Object temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }	
	public static void shuffle(int[] a) {
        if (a == null) throw new NullPointerException("argument array is null");
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + uniform(n-i);     // between i and n-1
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }	
	
	public static void main(String[] args) {
		StdOut.println(RandomGenerator.seed);
		StdOut.println(RandomGenerator.random.nextInt());
		StdOut.println(RandomGenerator.uniform(100));

		int n = 10;
		int[] a1 = new int[n];
		for (int i=0;i<n;i++) {a1[i] = i;}

		RandomGenerator.shuffle(a1);
		for (int i: a1) StdOut.print(i + " ");
		StdOut.println();

		//String[] a2 = {"A", "B", "C", "D"};
		String[] a2 = "A B C D".split(" "); 
		RandomGenerator.shuffle(a2);
		for (String i: a2) StdOut.print(i + " ");
		StdOut.println();
		
	}
}
