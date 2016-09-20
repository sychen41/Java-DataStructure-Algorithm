import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception1 {

	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			long x = sc.nextLong();
			long y = sc.nextLong();
			if (x>Integer.MAX_VALUE || x<Integer.MIN_VALUE ||
					y>Integer.MAX_VALUE || y<Integer.MIN_VALUE)
				throw new InputMismatchException();
			System.out.println(x/y);
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
		finally {
			if (sc!=null) sc.close();
		}
	}
}
