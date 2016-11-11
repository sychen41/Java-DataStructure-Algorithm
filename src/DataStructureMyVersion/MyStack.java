package DataStructureMyVersion;

/**
 * Created by Shiyi on 11/3/2016.
 */
public interface MyStack<T> extends Iterable<T> {
    T pop();
    void push(T item);
    T peek();
    boolean isEmpty();
}
