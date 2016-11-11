package DataStructureMyVersion;

/**
 * Created by Shiyi on 11/3/2016.
 */
public interface MyBST<K, V> extends Iterable<K> {
    void insert(K key, V val);
    boolean contains(K key);
    V get(K key);
    V delete(K key);
    String inOrder();
}
