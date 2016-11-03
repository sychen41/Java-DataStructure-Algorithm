package round2;

/**
 * Created by Shiyi on 11/2/2016.
 */
public interface MyLinkedList<T> extends Iterable<T> {
    public void addFirst(T item);
    public void addLast(T item);
    public T pollFirst();
    public T peekFirst();
    public boolean contains(T item);
    public void delete(T item);
}
