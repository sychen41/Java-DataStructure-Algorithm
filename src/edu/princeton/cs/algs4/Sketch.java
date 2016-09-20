package edu.princeton.cs.algs4;

import java.io.FileInputStream;

/**
 * Created by Shiyi on 9/10/2016.
 */
public class Sketch {
    private final Vector profile;

    public Sketch(String text, int k, int d) {
        int n = text.length();
        double[] freq = new double[d];
        for (int i=0; i<n-k+1; i++) {
        	String kgram = text.substring(i, i+k);
        	int hash = kgram.hashCode();
        	freq[Math.abs(hash%d)] += 1;
        }
        Vector vector = new Vector(freq);
        profile = vector.direction();
    }
    
    public double similarTo(Sketch other) {
    	return profile.dot(other.profile);
    }
    
    public String toString() {
    	return "" + profile;
    }
    
    public static void main(String[] args) {
    	int k = Integer.parseInt(args[0]);
    	int d = Integer.parseInt(args[1]);
    	//String test = 
    	//FileInputStream in1 = new FileInputStream("C:\Users\Shiyi\Documents\GitHub\AlgorithmPractice\data\")
    	/*
    	StdOut.print("Type a string: ");
        String s = StdIn.readString();
        StdOut.println("Your string was: " + s);
        StdOut.println();
        */
    	/*
        String[] filenames = StdIn.readAllStrings();
        int n = filenames.length;
        StdOut.print("    ");
        for (int i = 0; i < n; i++) {
            StdOut.printf("%8.4s", filenames[i]);
        }
        */
        String text = StdIn.readAll();
        Sketch sketch = new Sketch(text, k, d);
        StdOut.println(sketch);
    }
}
