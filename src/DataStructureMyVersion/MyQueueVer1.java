package DataStructureMyVersion;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Shiyi on 11/3/2016.
 */
public class MyQueueVer1<T> implements MyQueue<T> {
    private static class QueueNode<T> {
        T item;
        QueueNode<T> next;
        public QueueNode(T item) {
            this.item = item;
            this.next = null;
        }
    }
    private QueueNode<T> first;
    private QueueNode<T> last;
    public MyQueueVer1() {
        first = null;
        last = null;
    }
    @Override
    public void add(T item) {
        QueueNode<T> temp = new QueueNode<>(item);
        if (last != null)
            last.next = temp;
        last = temp;
        if (first == null)
            first = temp;
    }

    @Override
    public T remove() {
        if (isEmpty()) throw new NoSuchElementException();
        T temp = first.item;
        first = first.next;
        if (first == null)
            last = null;
        return temp;
    }

    @Override
    public T peek() {
        if (isEmpty()) return null;
        return first.item;
    }

    @Override
    public boolean isEmpty() {
        return first==null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<T> iter = iterator();
        while(iter.hasNext()) {
            sb.append(iter.next());
            sb.append(" ");
        }
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new MyQueueVer1Iter(first);
    }

    private class MyQueueVer1Iter implements Iterator<T> {
        private QueueNode<T> current;
        public MyQueueVer1Iter(QueueNode<T> first) {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public T next() {
            T temp = current.item;
            current = current.next;
            return temp;
        }
    }

    public static void main(String[] args) {
        MyQueue<Integer> q = new MyQueueVer1<>();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.toString());
        //System.out.println(q.peek());
        System.out.println(q.remove());
        System.out.println(q.toString());
        System.out.println(q.remove());
        System.out.println(q.toString());
        System.out.println(q.remove());
        System.out.println(q.toString());

    }
}
