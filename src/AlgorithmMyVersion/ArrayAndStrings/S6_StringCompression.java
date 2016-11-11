package AlgorithmMyVersion.ArrayAndStrings;

/**
 * Created by Shiyi on 11/10/2016.
 */
public class S6_StringCompression {
    //assuming string only contains uppercase and lowercase letters
    public static String strComp(String str) {
        if (str == null) return null;
        if (str.length() <= 2) return str;
        StringBuilder sb = new StringBuilder();
        Character cur = str.charAt(0);
        sb.append(cur);
        int charCount = 1;
        for(int i = 1; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (c == cur) {
                charCount++;
            } else {
                sb.append(charCount);
                cur = c;
                sb.append(cur);
                charCount = 1;
            }
        }
        sb.append(charCount);
        String result = sb.toString();
        return result.length() >= str.length() ? str : result;
    }
    public static void main(String[] args) {
        System.out.println(strComp("aabcccccaaa"));
    }
}
