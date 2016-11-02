package round1;

public class MoveGame2 {
	private static boolean isSolvable(int m, int[] arr, int i) {
	    if (i < 0 || arr[i] == 1) return false;
	    if ((i == arr.length - 1) || i + m > arr.length - 1) return true;

	    arr[i] = 1;
	    return isSolvable(m, arr, i + 1) || isSolvable(m, arr, i - 1) || isSolvable(m, arr, i + m);
	}
	public static void main(String[] args) {
		int[] a1 = {0,0,0,0,1};
		System.out.println(isSolvable(2,a1,0));
	}

}
