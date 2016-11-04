package warmUp;

public class Question {
	public static void main(String[] args) {
		int k = Integer.parseInt(args[0]);
		int max = (int) (Math.pow(2, k)-1);
		System.out.printf("Think of an integer between 0 and %d\n", max);
		
	}
}
