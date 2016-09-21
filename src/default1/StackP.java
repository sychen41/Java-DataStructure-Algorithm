package default1;
/**
 * Created by Shiyi on 9/20/2016.
 * @param <T>
 */

public class StackP<T> extends LinkedListP<T> {
    private int n;
    public StackP() {
        super();
        n = 0;
    }
    public void push(T item) {
        addFirst(item);
        n++;
    }
    public boolean isEmpty() {return head==null;}
    public int size() {return n;}
    public T pop() {
        T item = pollFirst();
        n--;
        return item;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(T item: this)
            sb.append(item+" ");
        return sb.toString();
    }
    public T peek() {return head.item;}
    public static void main(String[] args) {
        StackP<Integer> st = new StackP<>();
        st.push(1);
        st.printList();
        st.pop();
        System.out.println(st.size());
        //st.pop();
        //System.out.println(st.size());
    }
}
