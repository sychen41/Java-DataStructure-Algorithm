package round2;

/**
 * Created by Shiyi on 11/3/2016.
 */
public interface MyQueue<T> extends Iterable<T> {
    public void add(T item);
    public T remove();
    public T peek();
    public boolean isEmpty();
}
