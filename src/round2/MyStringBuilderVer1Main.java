package round2;

/**
 * Created by Shiyi on 11/3/2016.
 */
public class MyStringBuilderVer1Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Hello, ");
        sb.append("world.");
        System.out.println(sb.toString());

        MyStringBuilder msb = new MyStringBuilderVer1();
        msb.append("Hello, ");
        msb.append("world.");
        System.out.println(msb.toString());

    }
}
