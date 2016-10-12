package scalaComp.TreePrac;

/**
 * Created by Shiyi on 9/27/2016.
 */
public class Sum extends Tree {
    public Tree l;
    public Tree r;
    public Sum(Tree l, Tree r) {
        this.l = l;
        this.r = r;
    }
    public int eval() {
        return this.l.eval() + this.r.eval();
    }

    @Override
    public Tree derive(String s) {
        return new Sum(this.l.derive(s), this.r.derive(s));
    }

    @Override
    public String toString() {
        return "Sum(" + l.toString() + "," + r.toString() + ")";
    }

}
