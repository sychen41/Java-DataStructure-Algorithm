package AlgorithmMyVersion.Others;

import java.util.function.Consumer;

/**
 * Created by Shiyi on 11/17/2016.
 */
public class HighOrderFunctionSimulation {
    interface FunctionIF<T> {
        void doSomething(T item);
    }

    private int[] intArr;
    public HighOrderFunctionSimulation() {
        intArr = new int[]{1, 2, 3};
    }
    /*
    public static void method(FunctionIF fun) {
        for(Integer i: intArr)
            fun.doSomething(i);
    }
    */

    public void forEach(Consumer con) {
        for(Integer i: intArr) {
            con.accept(i);
        }
    }

    public static void main(String[] args) {
        HighOrderFunctionSimulation arr = new HighOrderFunctionSimulation();
        arr.forEach(item->System.out.println(item));
    }
}
