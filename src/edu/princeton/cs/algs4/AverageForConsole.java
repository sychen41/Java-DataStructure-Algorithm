package edu.princeton.cs.algs4;

import java.io.Console;

public class AverageForConsole {
	public static void main(String[] args) {
		Console c = System.console();
        if (c == null) {
            System.err.println("No console.");
            System.exit(1);
        }
        String input = c.readLine();
        System.out.println("Your input is " + input);
        int inputInt = Integer.parseInt(c.readLine("your input?"));
        System.out.println("you have entered a integer: " + inputInt);
	}
}
