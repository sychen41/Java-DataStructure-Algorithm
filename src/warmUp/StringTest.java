package warmUp;

/**
 * Created by Shiyi on 11/4/2016.
 */
public class StringTest {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = s1;//new String(s1);
        if(s1 == s2)
            System.out.println("s1 and s2 point to the same object/address");
        s1 = "Hello"; // s1 points to a new string
        // s2 still points to the string "hello"
        System.out.println(s2);
    }
}
