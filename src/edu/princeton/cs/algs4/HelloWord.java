package edu.princeton.cs.algs4;

public class HelloWord {
    static class Student {
    	int id;
		String name;
		Student(int id, String name) {
			this.id = id;
			this.name = name;
		}
	}
	private boolean flag;
	private String s = "HAHA";
	public void setFlag(boolean flag) {this.flag = flag;}
	public void print() {
		if (!flag) System.out.println("flag is false");
	}
	public void printS() {
		System.out.println("flag " + s);
	}
	public String toString() {return "This is a flag";}
	

	public static void main(String[] args) {
		System.out.println("Hello World");
		double a = Math.pow(15, 2);
		System.out.println(a);
		
		HelloWord h = new HelloWord();
		h.print(); // by default the flag = false
		h.printS();
		System.out.println(h); // h.toString() is called
        StdOut.println(h);
        Student s1 = new Student(1, "chen");
		Student s2 = s1;
        s2 = null;
        System.out.println(s1.name);
	}

}
