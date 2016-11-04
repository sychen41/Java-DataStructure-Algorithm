package round2;

/**
 * Created by Shiyi on 11/3/2016.
 */
public interface MyBST<K, V> extends Iterable<K> {
    public void insert(K key, V val);
    public boolean contains(K key);
    public V get(K key);
    public V delete(K key);
    public String inOrder();
}
