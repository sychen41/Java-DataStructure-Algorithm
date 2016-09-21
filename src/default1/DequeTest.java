package default1;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Scanner;

public class DequeTest {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        HashMap<Integer, Integer> info = new HashMap<>();
        int uniqueIntNum = 0;
        int max = 0;
        int n = in.nextInt();
        int m = in.nextInt();

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            if (!info.containsKey(num) || info.get(num) == 0) uniqueIntNum++;
            deque.add(num);
            if (info.containsKey(num)) info.put(num, info.get(num)+1);
            else info.put(num, 1);
            if (i>=m) {
                int toBeRemoved = deque.pollFirst();
                int currentCount = info.get(toBeRemoved);
                if (currentCount == 1) uniqueIntNum--;
                info.put(toBeRemoved, currentCount-1);
            }
            if (uniqueIntNum > max) max = uniqueIntNum;
            if (max == m) break;
        }
        System.out.println(max);
    }
}
