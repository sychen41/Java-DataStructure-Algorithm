package default1;
import java.util.HashSet;

public final class MoveGame {
	private int n;
	private int m;
	private int[] arr;
	private HashSet<String> usedMove;
	public MoveGame(int m, int[] arr) {
		this.n = arr.length;
		this.m = m;
		this.arr = new int[n];
		//defensive copy
		for(int i=0;i<n;i++) 
			this.arr[i] = arr[i];
		this.usedMove = new HashSet<>();
	}
	public boolean move(int pos) {
		boolean win = false;
		if (!win) {
			String move3 = pos + " " + (pos+m);
			if (pos+m>n-1) return true;
			else if (arr[pos+m]==0 && !usedMove.contains(move3)) {
				usedMove.add(move3);
				win = win || move(pos+m); 
			}
		}

		if (!win) {
			String move2 = pos + " " + (pos+1);
			if (pos+1>n-1) return true;
			else if (arr[pos+1]==0 && !usedMove.contains(move2)) { 
				usedMove.add(move2);
				win = win ||move(pos+1); 
			}
		}

		if (!win) {
			String move1 = pos + " " + (pos-1);
			if (pos>0 && arr[pos-1]==0 && !usedMove.contains(move1)) {
				usedMove.add(move1);
				win = win || move(pos-1); 
			}
		}
		
		if (win) return true;
		else return false;
	}
	public static void main(String[] args) {
		int[] a1 = {0,0,0,0,1};
		MoveGame g1 = new MoveGame(2,a1);
		System.out.println(g1.move(0));
		//LinkedListP<Integer> test = new LinkedListP<>();
        //int accessProtected = test.pro;
		//int accessPackagePrivate = test.pac;

	}
}
