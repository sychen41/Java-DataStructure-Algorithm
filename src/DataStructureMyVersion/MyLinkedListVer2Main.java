package DataStructureMyVersion;

/**
 * Created by Shiyi on 11/3/2016.
 */
public class MyLinkedListVer2Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> llist = new MyLinkedListVer2<>();
        llist.addFirst(3);
        llist.addFirst(2);
        llist.addFirst(1);

        llist.addLast(4);
        llist.addLast(5);
        llist.addLast(6);

        System.out.println(llist.toString());

        llist.delete(1);
        System.out.println(llist.toString());
        llist.delete(6);
        System.out.println(llist.toString());
        llist.delete(2);
        System.out.println(llist.toString());
        llist.delete(4);
        System.out.println(llist.toString());
        llist.delete(5);
        System.out.println(llist.toString());
        llist.delete(3);
        System.out.println(llist.toString());
        llist.delete(8);
        System.out.println(llist.toString());

        llist.addFirst(3);
        llist.addFirst(2);
        llist.addFirst(1);

        llist.addLast(4);
        llist.addLast(5);
        System.out.println(llist.toString());
    }
}
