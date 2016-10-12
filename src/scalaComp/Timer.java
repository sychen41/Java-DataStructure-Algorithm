package scalaComp;

/**
 * Created by Shiyi on 9/27/2016.
 */
public class Timer {
    interface Useless {
        void aMethod();
    }
    static void oncePerSecond(Useless useless) throws InterruptedException {
        while(true) {
            useless.aMethod();
            Thread.sleep(1000);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        /*
        oncePerSecond(new Useless() {
            @Override
            public void aMethod() {
                System.out.println("Time flies like an arrow");
            }
        });
        */
        oncePerSecond(()->System.out.println("Time flies like an arrow"));
    }
}
