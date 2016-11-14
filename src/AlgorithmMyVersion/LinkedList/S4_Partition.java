package AlgorithmMyVersion.LinkedList;
import DataStructureMyVersion.MyLinkedListVer1;
/**
 * Created by Shiyi on 11/13/2016.
 */
public class S4_Partition<T extends Comparable> extends MyLinkedListVer1<T> {
    //method 1
    public void partition(T pivot) {
        if (head == null) return;
        Node cur = head;
        Node leftHead = null, leftTail = null;
        Node rightHead = null, rightTail = null;
        while(cur!=null) {
            if(cur.item.compareTo(pivot) < 0) {
                if (leftHead == null) {
                    leftHead = cur;
                    leftTail = cur;
                } else {
                    leftTail.next = cur;
                    leftTail = leftTail.next;
                }
            } else {
                if (rightHead == null) {
                    rightHead = cur;
                    rightTail = cur;
                }
                else {
                    rightTail.next = cur;
                    rightTail = rightTail.next;
                }
            }
            cur = cur.next;
        }
        //if no element >= pivot
        if (rightHead == null) {
            head = leftHead;
            return;
        }
        //if no element < pivot
        else if (leftHead == null) {
            head = rightHead;
            return;
        }
        //if there are elements < pivot and elements >= pivot
        rightTail.next = null; //important but easy to miss. without it, a cycle will be formed.
        leftTail.next = rightHead;
    }
    //method 2
    public void partition2(T pivot) {
        Node cur = head;
        Node left = head;
        Node right = head;
        while(cur!=null) {
            Node next = cur.next;
            if (cur.item.compareTo(pivot) < 0) {
                cur.next = left;
                left = cur;
            } else {
                right.next = cur;
                right = cur;
            }
            cur = next;
        }
        right.next = null;
        head = left;
    }
    public static void main(String[] args) {
        S4_Partition<Integer> llist = new S4_Partition<>();
        llist.addFirst(1);
        llist.addFirst(2);
        llist.addFirst(10);
        llist.addFirst(5);
        llist.addFirst(8);
        llist.addFirst(5);
        llist.addFirst(3);
        llist.partition2(5);
        System.out.println(llist.toString());

    }
}
