package edu.princeton.cs.algs4;

public class Recursives {
	public static long factorial(int n) {
		if (n==1) return 1;
		return n*factorial(n-1);
	}
	public static int gcd(int a, int b) {
		if (a==0) return b;
		else if (b==0) return a;

		if (a>=b) 	return gcd(a%b, b);
		else		return gcd(b%a, a);	
	}
	public static int gcd2(int p, int q) {
        if (q == 0) return p;
        else return gcd(q, p % q);
    }
	
	public static void main(String[] args) {
		//StdOut.println(Recursives.factorial(3));
		//StdOut.println(Recursives.gcd2(68, 102));
	}

}
