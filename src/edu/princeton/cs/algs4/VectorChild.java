package edu.princeton.cs.algs4;

public class VectorChild extends Vector{

	public VectorChild(double[] data) {
		super(data);
	}

    // test client
    public static void main(String[] args) {
        double[] xdata = { 1.0, 2.0, 3.0, 4.0 };
        double[] ydata = { 5.0, 2.0, 4.0, 1.0 };

        VectorChild x = new VectorChild(xdata);
        VectorChild y = new VectorChild(ydata);

        StdOut.println("x        =  " + x);
        StdOut.println("y        =  " + y);
        StdOut.println("x + y    =  " + x.plus(y));
        StdOut.println("10x      =  " + x.times(10.0));
        StdOut.println("|x|      =  " + x.magnitude());
        StdOut.println("<x, y>   =  " + x.dot(y));
        StdOut.println("|x - y|  =  " + x.minus(y).magnitude());
    }
}
