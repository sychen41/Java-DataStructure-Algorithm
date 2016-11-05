package warmUp;

/**
 * Created by Shiyi on 11/4/2016.
 */
public class Parent {
    public String name;
    public Parent(String name) {
        this.name = name;
    }
    public void printName() {
        System.out.println("parent method: " + name);
    }
    public static void staticMethod() {
        System.out.println("parent static method");
    }
}
