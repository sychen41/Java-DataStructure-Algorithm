package AlgorithmMyVersion.ArrayAndStrings;

/**
 * Created by Shiyi on 11/10/2016.
 */
//p193 1.2 assuming whitespace counts and case sensitive
public class S2_CheckPermutation {
    //method 1: O(ologn)
    public static String sort(String str) {
        char[] charArr = str.toCharArray();
        java.util.Arrays.sort(charArr);
        return new String(charArr);
    }
    public static boolean ifPermutation(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        return sort(s1).equals(sort(s2));
    }
    //method 2: O(n) with extra space
    //assuming all ASCII strings
    public static boolean ifPermutation1(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        int[] charCount = new int[128];
        for(int i = 0; i < s1.length(); i++) {
            charCount[s1.charAt(i)]++;
        }
        for(int i = 0; i < s1.length(); i++) {
            charCount[s2.charAt(i)]--;
            //same length, if no negative value, then no positive value
            if (charCount[s2.charAt(i)] < 0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(S2_CheckPermutation.ifPermutation1("hello", "helo "));
    }
}
