
public class Convert10To2 {
	public static int powerOf2(double n) {
		int count = 0;
		if (n==1) return 1;
		int m = 1;
		while (m<n) {
			m = m*2;
			count+=1;
		}
		if (m!=n) count-=1;
		return count;
	}
	public static void main(String[] args) {
		double input = Double.parseDouble(args[0]);
		int count = powerOf2(input);
		double rest = input - Math.pow(2, count);
		int[] base2Format = new int[count+1];
		base2Format[count] = 1;
		while (rest!=0.0) {
			count = powerOf2(rest);
			rest -= Math.pow(2, count);
			base2Format[count] = 1;
		}

	}

}
