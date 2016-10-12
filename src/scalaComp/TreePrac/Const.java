package scalaComp.TreePrac;

/**
 * Created by Shiyi on 9/27/2016.
 */
public class Const extends Tree {
    public int v;
    public Const(int v) {
        this.v = v;
    }

    @Override
    public int eval() {
        return v;
    }

    @Override
    public Tree derive(String s) {
        return new Const(0);
    }

    @Override
    public String toString() {
        return "Const("+v+")";
    }


}
