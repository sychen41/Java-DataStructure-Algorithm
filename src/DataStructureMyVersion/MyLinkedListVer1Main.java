package DataStructureMyVersion;

/**
 * Created by Shiyi on 11/2/2016.
 */
public class MyLinkedListVer1Main {
    public static void main(String[] args) {
        MyLinkedListVer1<Integer> list1 = new MyLinkedListVer1<>();
        list1.addFirst(6);
        list1.addFirst(5);
        list1.addFirst(4);
        //System.out.println(list1.peekFirst());
        list1.addFirst(3);
        //System.out.println(list1.peekFirst());
        list1.addFirst(2);
        //System.out.println(list1.peekFirst());
        list1.addFirst(1);
        //System.out.println(list1.peekFirst());
        /*
        for (Integer x: list1)
            System.out.print(x+" ");
        System.out.println();
        if (list1.contains(2))
            System.out.println("contains 2");
        if (list1.contains(4))
            System.out.println("contains 4");
        */
        list1.weavingList();
        for (Integer x: list1)
            System.out.print(x+" ");
        System.out.println();

        /*
        list1.delete(2);
        if (list1.contains(2))
            System.out.println("contains 2");
        */

        //System.out.println(list1.pollFirst());
        //System.out.println(list1.pollFirst());
        //System.out.println(list1.pollFirst());
        //System.out.println(list1.pollFirst());
    }
}
