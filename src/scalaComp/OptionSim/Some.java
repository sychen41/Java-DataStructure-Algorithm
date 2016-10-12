package scalaComp.OptionSim;

/**
 * Created by Shiyi on 9/29/2016.
 */
public class Some<T> extends Option {
    public Some(T value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return "Some(" + value + ")";
    }
}
