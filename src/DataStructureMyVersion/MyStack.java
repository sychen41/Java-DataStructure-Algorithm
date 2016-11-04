package DataStructureMyVersion;

/**
 * Created by Shiyi on 11/3/2016.
 */
public interface MyStack<T> extends Iterable<T> {
    public T pop();
    public void push(T item);
    public T peek();
    public boolean isEmpty();
}
