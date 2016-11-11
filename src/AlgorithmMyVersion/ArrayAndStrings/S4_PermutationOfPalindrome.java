package AlgorithmMyVersion.ArrayAndStrings;

/**
 * Created by Shiyi on 11/10/2016.
 */
public class S4_PermutationOfPalindrome {
    //method 1: use hash table (here in the form of an array)
    public static boolean isPerOfPal(String str) {
        int[] charCount = new int[Character.getNumericValue('z')-
                Character.getNumericValue('a') + 1];
        for(char c: str.toLowerCase().toCharArray()) {
            int index = getIndex(c);
            if (index!=-1)
                charCount[index]++;
        }
        //check: if more than one char appeared odd times, than return false
        int oddCharCount = 0;
        for(Integer i: charCount) {
            if (i%2!=0)
                oddCharCount++;
            if (oddCharCount>1)
                return false;
        }
        return true;
    }

    private static int getIndex(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int target = Character.getNumericValue(c);
        if (target>=a && target<=z)
            return target - a;
        else return -1;//error flag
    }
    //method 2: use bit vector
    //todo

    public static void main(String[] args) {
        System.out.println(isPerOfPal("Tact Coa"));
    }
}
