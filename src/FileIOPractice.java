import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileIOPractice {
	public static void main(String[] args) {
		File file = new File(".\\data\\test.txt");
		try {
			PrintWriter output = new PrintWriter(file);
			output.println("Andy");
			output.println(1);
			output.close();
			System.out.println("closed");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.printf("Error Catched: %s\n", e);
		}
		Scanner input;
		try {
			input = new Scanner(file);
			String name = input.nextLine();
			int age = input.nextInt();
			System.out.printf("Name: %s Age: %d\n", name, age);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
