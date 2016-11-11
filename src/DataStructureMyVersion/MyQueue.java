package DataStructureMyVersion;

/**
 * Created by Shiyi on 11/3/2016.
 */
public interface MyQueue<T> extends Iterable<T> {
    void add(T item);
    T remove();
    T peek();
    boolean isEmpty();
}
