package warmUp;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileIOPractice {
	public static void main(String[] args) {
        File file = null;
        PrintWriter output = null;
		try {
			file = new File(".\\data1\\test.txt");
			output = new PrintWriter(file);
			output.println("Andy");
			output.println(1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.printf("Error Catched when creating file: %s\n", e);
		} finally {
			if (output!=null) {
				output.close();
				System.out.println("closed");
			}
		}
		Scanner input = null;
		try {
			input = new Scanner(file);
			String name = input.nextLine();
			int age = input.nextInt();
			System.out.printf("Name: %s Age: %d\n", name, age);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.printf("Error Catched when scanning file: %s\n", e);
			//e.printStackTrace();
		} finally {
			if (input!=null) input.close();
		}
	}
}
