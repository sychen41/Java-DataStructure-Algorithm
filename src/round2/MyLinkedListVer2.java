package round2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Shiyi on 11/3/2016.
 */
public class MyLinkedListVer2<T> implements MyLinkedList<T> {
    class Node {
        T item;
        Node prev;
        Node next;
        Node(T item) {
            this.item = item;
            this.prev = null;
            this.next = null;
        }
    }
    private Node head;
    private Node tail;
    public MyLinkedListVer2() {
        head = null;
        tail = head;
    }
    @Override
    public void addFirst(T item) {
        Node newNode = new Node(item);
        newNode.next = head;
        if (head!=null)
            head.prev = newNode;
        else
            tail = newNode;
        head = newNode;
    }

    @Override
    public void addLast(T item) {
        Node newNode = new Node(item);
        newNode.prev = tail;
        if (tail!=null)
            tail.next = newNode;
        else
            head = newNode;
        tail = newNode;
    }

    @Override
    public T pollFirst() {
        if (head==null) throw new NoSuchElementException();
        T temp = head.item;
        head = head.next;
        head.prev = null;
        return temp;
    }

    @Override
    public T peekFirst() {
        if (head==null) throw new NoSuchElementException();
        return head.item;
    }

    @Override
    public boolean contains(T item) {
        Node cur = head;
        while(cur!=null) {
            if(cur.item.equals(item))
                return true;
            cur = cur.next;
        }
        return false;
    }

    @Override
    public void delete(T item) {
        Node cur = head;
        while(cur!=null) {
            if (cur.item.equals(item))
                break;
            cur = cur.next;
        }
        // found the node that has the item
        if (cur!=null) {
            // if this node is head
            if (cur == head) {
                head.prev = null;
                head = head.next;
                // if the node is also tail
                if (cur == tail) {
                    tail = head; // this list is essentially empty
                }
            }
            // if the node is tail
            else if (cur == tail) {
                tail = tail.prev;
                tail.next = null;
                // if the node is also head
                // handled by the previous condition
            }
            // if the node is neither head nor tail
            else {
                Node prev = cur.prev;
                Node next = cur.next;
                prev.next = cur.next;
                next.prev = cur.prev;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator iter = new MyLinkedListVer2Iter(head);
        while(iter.hasNext()) {
            sb.append(iter.next());
            sb.append(" ");
        }
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListVer2Iter(head);
    }

    private class MyLinkedListVer2Iter implements Iterator<T> {
        private Node cur;
        public MyLinkedListVer2Iter(Node head) {
            cur = head;
        }

        @Override
        public boolean hasNext() {
            return cur!=null;
        }

        @Override
        public T next() {
            T curItem = cur.item;
            cur = cur.next;
            return curItem;
        }
    }
}
