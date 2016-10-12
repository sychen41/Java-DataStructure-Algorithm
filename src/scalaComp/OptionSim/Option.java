package scalaComp.OptionSim;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shiyi on 9/29/2016.
 */
public class Option<T>
{
    public T value;
    public static<T> Option init(T value) {
        if (value != null)
            return new Some(value);
        else
            return new None();
    }

    @Override
    public String toString() {
        return "Option";
    }

    public static void main(String[] args) {
        Option<Integer> o1 = Option.init("haha");
        System.out.println(o1);

        Option<String> o2 = Option.init(null);
        System.out.println(o2);


    }
}
