package round1;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class StringValueComp3 {
	public static void main(String[] args) {
		String[] strArr = {"10", "2", "3", "25"};
		// inner class
		class CompByDouble implements Comparator<String> {
			@Override
			public int compare(String o1, String o2) {
				return new Double(o1).compareTo(new Double(o2));
			}
		}
		class CompByBigDec implements Comparator<String> {
			@Override
			public int compare(String o1, String o2) {
				return new BigDecimal(o1).compareTo(new BigDecimal(o2));
			}
		}
		//Arrays.sort(strArr, new CompByBigDec());;
		//Arrays.sort(strArr, new CompByDouble());;

		/*
		//Anonymouse Class
		Arrays.sort(strArr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return new Double(o1).compareTo(new Double(o2));
			}
		});
		//resersed order
		Arrays.sort(strArr, Collections.reverseOrder(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return new Double(o1).compareTo(new Double(o2));
			}
		}));
		*/

		//Lambda
		//Arrays.sort(strArr, 
		//		(String s1, String s2) -> new BigDecimal(s1).compareTo(new BigDecimal(s2)));

		//Only sort first two elements, in reversed order.
		Arrays.sort(strArr, 0, 2,  
				Collections.reverseOrder(
						(s1, s2) -> new BigDecimal(s1).compareTo(new BigDecimal(s2))
						)
				);
		System.out.println(Arrays.toString(strArr));
	}
}
