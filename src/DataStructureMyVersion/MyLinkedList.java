package DataStructureMyVersion;

/**
 * Created by Shiyi on 11/2/2016.
 */
public interface MyLinkedList<T> extends Iterable<T> {
    void addFirst(T item);
    void addLast(T item);
    T pollFirst();
    T peekFirst();
    boolean contains(T item);
    void delete(T item);
}
