package round1;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class StringValueComp implements Comparable<StringValueComp> {
	public String str;
	
	public StringValueComp(String str) {
		this.str = str;
	}
	@Override
	public int compareTo(StringValueComp that) {
		if (Double.parseDouble(this.str) < Double.parseDouble(that.str)) return -1; 
		else if (Double.parseDouble(this.str) > Double.parseDouble(that.str)) return 1; 
		else return 0;
	}
		
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringValueComp[] svcArr = new StringValueComp[n];
		for(int i=0;i<n;i++) svcArr[i] = new StringValueComp(sc.next());
		sc.close();
		Arrays.sort(svcArr, Collections.reverseOrder());
		for(int i=0;i<n;i++) System.out.println(svcArr[i].str); 

	}
}
