package edu.princeton.cs.algs4;
import java.util.concurrent.ThreadLocalRandom;

public class GuessTheNumber {
	public static void main(String[] args) {
		int theNumber = ThreadLocalRandom.current().nextInt(0, 101);
		StdOut.println("Hit me with a number between 0 and 100");
		int yourGuess;
		boolean guess = false;
		while (!guess) {
			StdOut.println("Hit me");
			yourGuess = StdIn.readInt();
			if 		(yourGuess == theNumber) guess = true;
			else if (yourGuess < theNumber) StdOut.println("too low");
			else							StdOut.println("too high");
		}
		StdOut.println("Bingo!");
	}
}
