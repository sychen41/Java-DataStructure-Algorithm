package AlgorithmMyVersion.ArrayAndStrings;

/**
 * Created by Shiyi on 11/10/2016.
 */
public class S5_OneAway {
    public static boolean ifOneAway(String s1, String s2) {
        if (s1.length() == s2.length())
            return ifOneReplacementAway(s1, s2);
        else if (s1.length() - s2.length() == 1)
            return ifOneRemovalAway(s1, s2);
        else if (s2.length() - s1.length() == 1)
            return ifOneRemovalAway(s2, s1);
        else
            return false;//length differs more than 1
    }

    private static boolean ifOneRemovalAway(String s1, String s2) {
        int removalCount = 0;
        int indexOfS2 = 0;
        for(int i=0;i<s1.length();i++) {
            if (s1.charAt(i) == s2.charAt(indexOfS2))
                indexOfS2++;
            else {
                removalCount++;
            }
            if (removalCount > 1) {
                return false;
            }
            if (indexOfS2 == s2.length()) //s2 has reached the end, removalCount still more > 1, meaning true
                return true;
        }
        return true;
    }

    private static boolean ifOneReplacementAway(String s1, String s2) {
        int replacementCount = 0;
        for(int i=0;i<s1.length();i++) {
            if (s1.charAt(i) != s2.charAt(i))
                replacementCount++;
            if (replacementCount>1)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(ifOneAway("pale", "bae"));
    }
}
