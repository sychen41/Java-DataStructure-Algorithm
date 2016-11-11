package DataStructureMyVersion;

/**
 * Created by Shiyi on 11/2/2016.
 */
public interface MyArrayList<T> extends Iterable<T> {
    void add(T item);
    void add(T item, int index);
    boolean contains(T item);
    void remove(int index);
    T get(int index);
    boolean isEmpty();
    int size();
}
