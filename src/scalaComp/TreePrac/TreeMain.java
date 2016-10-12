package scalaComp.TreePrac;

/**
 * Created by Shiyi on 9/27/2016.
 */
public class TreeMain {
    public static void main(String[] args) {
        Tree t = new Sum(new Sum(new Var("x"),new Var("x")), new Sum(new Const(7), new Var("y")));
        System.out.println(t.eval());
        System.out.println(t.derive("x"));
    }
}
