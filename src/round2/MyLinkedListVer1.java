package round2;

import java.util.Iterator;

/**
 * Created by Shiyi on 11/2/2016.
 */
public class MyLinkedListVer1<T> implements MyLinkedList<T> {
    class Node {
        T item;
        Node next;
        Node(T item) {
            this.item = item;
            this.next = null;
        }
    }
    private Node head;
    public MyLinkedListVer1() {
        head = null;
    }
    @Override
    public void addFirst(T item) {
        Node temp = new Node(item);
        temp.next = head;
        head = temp;
    }

    @Override
    public void addLast(T item) {
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(item);
    }

    @Override
    public T pollFirst() {
        T temp = null;
        if (head!=null) {
            temp = head.item;
            head = head.next;
        }
        return temp;
    }

    @Override
    public T peekFirst() {
        if (head!=null)
            return head.item;
        else
            return null;
    }

    @Override
    public boolean contains(T item) {
        Node temp = head;
        while(temp!=null) {
            if (temp.item.equals(item)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    @Override
    public void delete(T item) {
        if (this.contains(item)) {
            if (head.next == null) {
                head = null;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    if (temp.next.item.equals(item)) {
                        temp.next = temp.next.next;
                    }
                }
            }
        }
    }

    // change 1->2->3->4 to 1->3->2->4 using fast-slow pointer technique
    public void weavingList() {
        Node fast = head;
        Node slow = head;
        while(fast!=null) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        // now fast has reached the end, slow has reached the middle
        // move the fast to the beginning, and start weaving
        fast = head;
        head = mergeTwoList(fast,slow);
    }

    private Node mergeTwoList(Node head1, Node head2) {
        Node newHead = head1;
        Node current = newHead;
        while(head2.next!=null) {
            head1 = head1.next;
            current.next = head2;
            current = current.next;
            head2 = head2.next;
            current.next= head1;
            current = current.next;
        }
        current.next = head2;
        return newHead;
    }
    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator(head);
    }

    private class MyLinkedListIterator implements Iterator<T> {
        private Node current;
        public MyLinkedListIterator(Node head) {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T temp = current.item;
            current = current.next;
            return temp;
        }
    }
}
