package round1;

public class RandomWalker {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		boolean[][] visited = new boolean[n][n];
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i=0; i<n; i++) x[i] = n/2;
		for (int i=0; i<n; i++) y[i] = n/2;
		int visitedCount = 1;
		visited[n/2][n/2] = true;
		int steps = 0;
		while (visitedCount != n*n) {
			steps++;
			for (int i = 0; i < n; i++) {
				double r = Math.random();
				if (r<0.25) 		x[i]++;
				else if (r<0.5)		x[i]--;
				else if (r<0.75)	y[i]++;
				else				y[i]--;
				if (x[i] >= 0 && x[i] < n && y[i] >= 0 && y[i] < n && visited[x[i]][y[i]] == false) {
					visited[x[i]][y[i]] = true;
					visitedCount++;
				}
			}
		}
		System.out.println(steps);
	}
}
