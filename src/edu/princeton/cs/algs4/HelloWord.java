package edu.princeton.cs.algs4;

public class HelloWord {
	private boolean flag;
	public void setFlag(boolean flag) {this.flag = flag;}
	public void print() {
		if (!flag) System.out.println("flag");
	}
	public void print1() {
		System.out.println("flag");
	}
	public String toString() {return "This is a flag";}

	public static void main(String[] args) {
		System.out.println("Hello World");
		double a = Math.pow(15, 2);
		System.out.println(a);
		
		HelloWord h = new HelloWord();
		h.print(); // by default the flag = false
		System.out.println(h); // h.toString() is called
	}

}
