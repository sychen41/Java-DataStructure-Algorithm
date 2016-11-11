package DataStructureMyVersion;

/**
 * Created by Shiyi on 11/2/2016.
 */
public interface MyHashTable<K,V> {
    void put(K key, V val);
    V get(K key);
    boolean contains(K key);
    void delete(K key);
}
