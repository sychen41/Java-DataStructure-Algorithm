package scalaComp.TreePrac;

import java.util.HashMap;

/**
 * Created by Shiyi on 9/27/2016.
 */
public class Var extends Tree {
    static HashMap<String, Integer> hm;
    static {
        hm = new HashMap<>();
        hm.put("x", 5);
        hm.put("y", 7);
    }

    public String n;
    public Var(String n) {
        this.n = n;
    }

    @Override
    public int eval() {
        return hm.get(n);
    }

    @Override
    public Tree derive(String s) {
        return this.n.equals(s)? new Const(1) : new Const(0);
    }

    @Override
    public String toString() {
        return "Var(" + n + ")";
    }
}
