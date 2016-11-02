package round1;

/**
 * Created by Shiyi on 9/28/2016.
 */
public class HelloWorld {
    public static int add(int a, int b) {
        return a + b;
    }
    public static int add2(int a, int b) {
        try {
            return Math.addExact(a, b);
        } catch (ArithmeticException e) {
            //System.out.println(e);
            throw new ArithmeticException("overflow");
        }
    }
    public static void main(String[] args) {
        int overflow = add(Integer.MAX_VALUE,Integer.MAX_VALUE);
        int underflow = add(Integer.MIN_VALUE, Integer.MIN_VALUE);
        System.out.println(overflow); // -2
        System.out.println(underflow); // 0

        try {
            int overflow2 = add2(Integer.MAX_VALUE, Integer.MAX_VALUE);
            System.out.println(overflow2); // overflow  exception
        } catch (ArithmeticException e) {
            System.out.println(e);
        }
        try {
            int underflow2 = add2(Integer.MIN_VALUE, Integer.MIN_VALUE);
            System.out.println(underflow2); // overflow exception
        } catch (ArithmeticException e) {
            System.out.println(e);
        }

    }
}
