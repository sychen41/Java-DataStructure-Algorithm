package edu.princeton.cs.algs4;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumGen {
	public static void main(String[] args) {
		int max = 10;
		for (int i = 0; i < max; i++) {
			System.out.println(ThreadLocalRandom.current().nextInt(0, max));
		}
	}
}
