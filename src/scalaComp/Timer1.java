package scalaComp;

import java.util.function.Consumer;

/**
 * Created by Shiyi on 9/27/2016.
 */
public class Timer1 {
    static void oncePerSecond(Consumer<String> con) throws InterruptedException {
        while(true) {
            String s = "Time flies like an arrpw";
            con.accept(s);
            Thread.sleep(1000);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        oncePerSecond(s -> System.out.println(s));
    }
}
