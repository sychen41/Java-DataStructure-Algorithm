package AlgorithmMyVersion.ArrayAndStrings;

/**
 * Created by Shiyi on 11/11/2016.
 */
public class S9_StringRotation {
    public static boolean isRotation(String rotated, String original) {
        String temp = original + original;
        if (rotated.length() == original.length() &&
                temp.contains(rotated))
            return true;
        return false;
    }
    public static void main(String[] args) {
        System.out.println(isRotation("htc", "cth"));
    }
}
