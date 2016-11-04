package DataStructureMyVersion;

/**
 * Created by Shiyi on 11/2/2016.
 */
public interface MyArrayList<T> extends Iterable<T> {
    public void add(T item);
    public void add(T item, int index);
    public boolean contains(T item);
    public void remove(int index);
    public T get(int index);
    public boolean isEmpty();
    public int size();
}
