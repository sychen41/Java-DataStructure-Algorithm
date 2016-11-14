package AlgorithmMyVersion.LinkedList;

import DataStructureMyVersion.MyLinkedListVer1;
/**
 * Created by Shiyi on 11/11/2016.
 */
public class S2_ReturnKthToLast<T> extends MyLinkedListVer1<T> {
    // method 1: recursion. time: O(n). space: O(n): recursion stack
    public T returnKthToLast(int k) {
        Node theNode = new Node(); //use as a wrapper
        returnKthToLast(k, head, theNode);
        return theNode.item;
    }

    private int returnKthToLast(int k, Node node, Node theNode) {
        if (node == null) return 0;
        int returnValue = returnKthToLast(k, node.next, theNode);
        if (returnValue == -1) return -1;//found the kth node, no need to execute the code further down
        int nth = 1 + returnValue;
        if (nth == k) {
            //theNode = node; //useless assignment. won't carry to the caller, just like a integer variable a, you make a = 1, a in the caller will still be the old value
            theNode.item = node.item;
            return -1;
        }
        else return nth;
    }

    // method 2: iterative. time: O(n), space: O(1): two pointers
    public T returnKthToLast2(int k) {
        Node backPointer = head;
        Node frontPointer = head;
        int distanceOfTwoPointers = 1;
        while(distanceOfTwoPointers < k) {
            if (frontPointer.next==null) throw new IllegalArgumentException("There are less than " + k + " nodes in the list");
            frontPointer = frontPointer.next;
            distanceOfTwoPointers++;
        }
        //now these two pointers are k node apart,
        //we can move the front and back pointer to the end at the same time,
        //that will automatically put the back pointer
        //to the kth node to the last.
        while(frontPointer.next!=null) {
            frontPointer = frontPointer.next;
            backPointer = backPointer.next;
        }
        return backPointer.item;
    }

    public static void main(String[] args) {
        S2_ReturnKthToLast<Integer> llist = new S2_ReturnKthToLast<>();
        llist.addFirst(5);
        llist.addFirst(4);
        llist.addFirst(3);
        llist.addFirst(2);
        llist.addFirst(1);
        System.out.println(llist.toString());
        System.out.println(llist.returnKthToLast(2));
        System.out.println(llist.returnKthToLast2(5));
        System.out.println(llist.returnKthToLast2(6));//will throw an exception
    }
}
