package default1;

import static java.lang.System.out;
/**
 * Created by Shiyi on 10/11/2016.
 */
public class CallBack {
    interface Ainterface {
        void callBack();
    }
    public static void cookAndDeliverFood(Ainterface ainterface) throws InterruptedException {
        Thread.sleep(3000);
        ainterface.callBack();
    }

    public static void placeAnOrder(int orderNumber) throws InterruptedException {
        class Aclass implements Ainterface {

            @Override
            public void callBack() {
                out.println("Delivered food order" + orderNumber);
            }
        }
        out.println("Customer order" + orderNumber);
        //cookAndDeliverFood(new Aclass());
        cookAndDeliverFood(()->{
            out.println("Delivered food ORDER " + orderNumber);
        });
    }
    public static void main(String[] args) throws InterruptedException {
        placeAnOrder(1);
        placeAnOrder(2);
        placeAnOrder(3);
        placeAnOrder(4);
    }
}
