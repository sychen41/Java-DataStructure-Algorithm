package round2;

import javax.swing.text.html.HTMLDocument;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Stack;

/**
 * Created by Shiyi on 11/3/2016.
 */
public class MyStackVer1<T> implements MyStack<T> {

    private static class StackNode<T> {
        T data;
        StackNode next = null;
        StackNode(T data) {
            this.data = data;
        }
    }
    private StackNode<T> head;
    public MyStackVer1() {
        head = null;
    }
    @Override
    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        T temp = head.data;
        head = head.next;
        return temp;
    }

    @Override
    public void push(T data) {
        StackNode<T> temp = new StackNode(data);
        temp.next = head;
        head = temp;
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return head.data;
    }

    @Override
    public boolean isEmpty() {
        return head==null;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyStackVer1Iter(head);
    }

    private class MyStackVer1Iter implements Iterator<T> {
        private StackNode<T> current;
        public MyStackVer1Iter(StackNode<T> head) {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public T next() {
            T temp = current.data;
            current = current.next;
            return temp;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator iter = iterator();
        while(iter.hasNext()) {
            sb.append(iter.next());
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MyStack<Integer> st = new MyStackVer1<>();
        st.push(3);
        st.push(2);
        st.push(1);
        System.out.println(st.peek());
        System.out.println(st.pop());
        System.out.println(st.toString());
    }
}
