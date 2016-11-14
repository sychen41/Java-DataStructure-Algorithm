package AlgorithmMyVersion.LinkedList;
import DataStructureMyVersion.MyLinkedListVer1;

import java.util.HashSet;

/**
 * Created by Shiyi on 11/11/2016.
 */
public class S1_RemoveDups<T> extends MyLinkedListVer1<T> {
    public void removeDups() {
        //removeDups(head);
        removeDups2(head);
    }

    //method 1: time: O(n), space : O(n)
    private void removeDups(Node head) {
        HashSet<T> set = new HashSet<>();
        Node cur = head;
        set.add(cur.item);
        while(cur!=null && cur.next!=null) {
            if (!set.contains(cur.next.item)) {
                set.add(cur.next.item);
                cur = cur.next;
            }
            else {
                cur.next = cur.next.next;
            }
        }
    }
    //method 2: time: O(n^2), space: O(1)
    private void removeDups2(Node head) {
        Node cur = head;
        while(cur!=null) {
            Node scanner = cur;
            T curItem = cur.item;
            while(scanner.next!=null) {
                if (scanner.next.item.equals(curItem)) {
                    scanner.next = scanner.next.next;
                } else
                    scanner = scanner.next;
            }
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        S1_RemoveDups<Integer> llist = new S1_RemoveDups<>();
        llist.addFirst(1);
        llist.addFirst(2);
        llist.addFirst(2);
        llist.addFirst(4);
        llist.addFirst(3);
        llist.addFirst(3);
        llist.addFirst(3);
        llist.addFirst(2);
        llist.addFirst(1);
        llist.addFirst(1);
        llist.removeDups();
        System.out.println(llist.toString());
    }


}
