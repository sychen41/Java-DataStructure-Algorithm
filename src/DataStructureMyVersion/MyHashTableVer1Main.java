package DataStructureMyVersion;

/**
 * Created by Shiyi on 11/2/2016.
 */
public class MyHashTableVer1Main {
    public static void main(String[] args) {
        MyHashTableVer1<String, Integer> ht = new MyHashTableVer1<>(2);
        //MyHashTableVer1<String, Integer> ht2 = new MyHashTableVer1<>();
        ht.put("a", 1);
        ht.put("b", 2);
        ht.put("c", 3);
        System.out.println("b's value is " + ht.get("b"));
        if (ht.contains("c"))
            System.out.println("contains c");
        if (ht.contains("d"))
            System.out.println("contains d");
        ht.delete("a");
        if (ht.contains("a"))
            System.out.println("contains a");
        ht.delete("b");
        if (ht.contains("b"))
            System.out.println("contains b");
        ht.delete("c");
        if (ht.contains("c"))
            System.out.println("contains c");
        ht.delete("a");
        if (ht.contains("a"))
            System.out.println("contains a");
    }
}
