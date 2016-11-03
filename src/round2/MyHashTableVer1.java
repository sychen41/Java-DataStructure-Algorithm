package round2;

/**
 * Created by Shiyi on 11/2/2016.
 */
public class MyHashTableVer1<K,V> implements MyHashTable<K,V> {
    class Data {
        K key;
        V val;
        Data(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }
    private MyLinkedListVer1<Data>[] arrayOfLList;
    private int arrLength;

    public MyHashTableVer1() {
        this(5);  //default value
    }
    public MyHashTableVer1(int size) {
        this.arrLength = size;
        arrayOfLList = new MyLinkedListVer1[this.arrLength];
        for(int i=0; i<this.arrLength; i++)
            arrayOfLList[i] = new MyLinkedListVer1<>();
    }
    // instance initializer
    {
        //wrong
        /*
        for(MyLinkedList llist: arrayOfLList)
            llist = new MyLinkedList();
        */
        //wrong either
        /*
        for(int i=0; i<this.arrLength; i++)
            arrayOfLList[i] = new MyLinkedList<>();
        */
    }

    private int hash(K key) {
        // make the hashcode a positive number
        return (key.hashCode() & 0x7fffffff) % this.arrLength;
    }
    @Override
    public void put(K key, V val) {
        Data temp = new Data(key, val);
        arrayOfLList[hash(key)].addFirst(temp);
    }

    @Override
    public V get(K key) {
        V temp = null;
        for(Data d: arrayOfLList[hash(key)]) {
            if (d.key.equals(key)) {
                temp = d.val;
                break;
            }
        }
        return temp;
    }

    @Override
    public boolean contains(K key) {
        boolean found = false;
        for(Data d: arrayOfLList[hash(key)]) {
            if (d.key.equals(key)) {
                found = true;
                break;
            }
        }
        return found;
    }

    @Override
    public void delete(K key) {
        if (this.contains(key)) {
            int index = hash(key);
            for (Data d : arrayOfLList[index]) {
                if (d.key.equals(key)) {
                    arrayOfLList[index].delete(d);
                    break;
                }
            }
        }
    }
}
