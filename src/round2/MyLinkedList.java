package round2;

import java.util.Iterator;

/**
 * Created by Shiyi on 11/2/2016.
 */
public class MyLinkedList<T> implements MyList<T> {
    class Node {
        T item;
        Node next;
        Node(T item) {
            this.item = item;
            this.next = null;
        }
    }
    private Node head;
    public MyLinkedList() {
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
