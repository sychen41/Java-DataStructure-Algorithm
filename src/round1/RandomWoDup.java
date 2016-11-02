package round1;

import java.util.*;

/**
 * Created by Shiyi on 9/24/2016.
 */
public class RandomWoDup {
    // generate shuffled array
    public static int[] arrRange(int start, int exclusiveEnd) {
        if (start >= exclusiveEnd) throw new IllegalArgumentException("arg1 must be less than arg2");
        int size = exclusiveEnd - start;
        int[] arr = new int[size];
        for(int i=0;i<size;i++) arr[i] = start++;
        shuffle(arr);
        return arr;
    }
    private static void shuffle(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            // index is chosen uniformly in [i, n-1]
            int randomIndex = i + (int)(Math.random()*(n-i));
            int temp = arr[randomIndex];
            arr[randomIndex] = arr[i];
            arr[i] = temp;
        }
    }
    // generate shuffled ArrayList
    public static ArrayList listRange(int start, int exclusiveEnd) {
        if (start >= exclusiveEnd) throw new IllegalArgumentException("arg1 must be less than arg2");
        int size = exclusiveEnd - start;
        ArrayList<Integer> alist = new ArrayList<>();
        while(alist.size() < size) {
            alist.add(start++);
        }
        Collections.shuffle(alist);
        return alist;
    }
    // generate n random numbers without duplicate
    public static Set<Integer> nRandomNums(int amount) {
        Set<Integer> set = new HashSet<>();
        Random rand = new Random();
        while(set.size() < amount) {
            set.add(rand.nextInt());
        }
        return set;
    }
    /*
    public static int[] nRandomNums(int amount, int start, int exclusiveEnd) {
        if (1.0*amount/(exclusiveEnd-start) > 0.2)

        else

    }
    */
    // if need 10 numbers from [0, 1000] than use technique like nRandomNums
    // if need 700 numbers from [0, 1000] than just shuffle the array [0-1000] and pick the first 700
}
