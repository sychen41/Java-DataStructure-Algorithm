package round1;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class StackUtil {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	   HashMap<Character, Character> p = new HashMap<>();
	   p.put('[',']');
	   p.put('{','}');
	   p.put('(',')');
	   while (sc.hasNext()) {
		   Stack<Character> st = new Stack<>();
		   boolean balanced = true;
		   String input=sc.next();
		   int length = input.length();
		   if (length%2 != 0) balanced = false;
		   else {
			   for(int i=0;i<length;i++) {
				   char c = input.charAt(i);
				   if (c == '[' || c == '{' || c == '(' ) st.push(c); 
				   else {
					   if (st.empty() || c!=p.get(st.pop())) {
						   balanced = false;
						   break;
					   }
				   } 
					   
			   }
		   }
		   if (balanced) System.out.println("true");
		   else System.out.println("false");
	   }

	}
}
