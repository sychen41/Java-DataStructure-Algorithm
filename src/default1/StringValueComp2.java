package default1;
import java.util.Scanner;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

public class StringValueComp2 implements Comparable<StringValueComp2> {
	public String str;
	
	public StringValueComp2(String str) {
		this.str = str;
	}
	@Override
	public int compareTo(StringValueComp2 that) {
		/*BigDecimal bThis = new BigDecimal(this.str);
		BigDecimal bThat = new BigDecimal(that.str);
		return bThis.compareTo(bThat);
		*/
		return new BigDecimal(this.str).compareTo(new BigDecimal(that.str));
	}
		
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringValueComp2[] svcArr = new StringValueComp2[n];
		for(int i=0;i<n;i++) svcArr[i] = new StringValueComp2(sc.next());
		sc.close();
		Arrays.sort(svcArr, Collections.reverseOrder());
		for(int i=0;i<n;i++) System.out.println(svcArr[i].str); 

	}
}