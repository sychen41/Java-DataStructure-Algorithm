package AlgorithmMyVersion.ArrayAndStrings;

import java.util.Arrays;

/**
 * Created by Shiyi on 11/10/2016.
 */
public class S1_CheckDupInString {
    //p90 1.1
    //if we can't use additional data structure
    //method 0: O(n^2) extra space: 0
    public static boolean existDuplicate(String str) {
        for(int i=0;i<str.length();i++) {
            for(int j=i+1;j<str.length();j++) {
                if (str.charAt(i) == str.charAt(j))
                    return true;
            }
        }
        return false;
    }

    //if we can use additional structure
    //method 1: O(nlog(n)) by sorting and comparing neighbors
    public static boolean existDuplicate1(String str) {
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        for(int i=0;i<charArr.length-1;i++) {
            if (charArr[i] == charArr[i+1])
                return true;
        }
        return false;
    }

    //method 2: O(n): trading space for time, assume ASCII string (only 128 possibilities)
    //extra space: O(1) : an array of 128 integers.
    public static boolean existDuplicate2(String str) {
        int[] charArr = new int[128];
        for(int i=0;i<str.length();i++) {
            int charCode = /*(int)*/(str.charAt(i)); //no need explicitly cast
            if (charArr[charCode] == 0)
                charArr[charCode] = 1;
            else
                return true;
        }
        return false;
    }
    //method 3: O(n) extra space: O(1) : a single integer
    //todo

    public static void main(String[] args) {
        System.out.println(S1_CheckDupInString.existDuplicate2("hello"));
    }
}
