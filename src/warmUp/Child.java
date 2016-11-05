package warmUp;

/**
 * Created by Shiyi on 11/4/2016.
 */
public class Child extends Parent{
    public Child(String name) {
        super(name);
    }
    public void printName() {
        System.out.println("child method: " + name);
    }
    //can NOT override static method
    public static void staticMethod() {
        System.out.println("Child static method");
    }
    public static void main(String[] args) {
        Parent p = new Parent("Parent");
        p.printName();
        p.staticMethod(); //better write Parent.staticMethod()

        p = new Child("Child");
        p.printName();
        p.staticMethod();

        Child c = new Child("Child");
        c.printName();
        c.staticMethod();
    }
}
