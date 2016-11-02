package round2;

/**
 * Created by Shiyi on 11/2/2016.
 */
public interface MyHashTable<K,V> {
    public void put(K key, V val);
    public V get(K key);
    public boolean contains(K key);
    public void delete(K key);
}
