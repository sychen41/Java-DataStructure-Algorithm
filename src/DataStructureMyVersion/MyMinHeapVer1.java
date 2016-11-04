package DataStructureMyVersion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Shiyi on 11/3/2016.
 */
public class MyMinHeapVer1<T extends Comparable<T>> implements MyMinHeap<T>, Iterable<T> {
    private ArrayList<T> aList;
    public MyMinHeapVer1() {
        aList = new ArrayList<>();
    }

    @Override
    public void insert(T data) {
        aList.add(data);
        bubbleUp(aList.size()-1);
    }
    private void bubbleUp(int index) {
        // iterate until reached root
        while(index != 0) {
            int parentIndex = parentIndex(index);
            int comp = aList.get(index).compareTo(aList.get(parentIndex));
            if (comp < 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else
                break;
        }
    }

    private void swap(int index, int parent) {
        T temp = aList.get(index);
        aList.set(index, aList.get(parent));
        aList.set(parent, temp);
    }

    private int parentIndex(int index) {
        return (index-1)/2;
    }

    @Override
    public T extractMin() {
        T min = aList.get(0);
        T last = aList.remove(aList.size()-1);
        aList.set(0, last);
        bubbleDown(0);
        return min;
    }

    private void bubbleDown(int index) {
        // do as long as the index still has child
        while(index < aList.size()/2) {
            int smallerChildIndex = smallerChildIndex(index);
            int comp = aList.get(index).compareTo(aList.get(smallerChildIndex));
            if (comp > 0) {
                swap(index, smallerChildIndex);
                index = smallerChildIndex;
            } else
                break;
        }
    }

    private int smallerChildIndex(int index) {
        int leftChildIndex = (index+1)*2-1;
        int rightChildIndex = (index+1)*2;
        // if right child exists, return smaller one
        if (rightChildIndex < aList.size())
            return aList.get(leftChildIndex).compareTo(aList.get(rightChildIndex)) < 0 ? leftChildIndex : rightChildIndex;
        // right child NOT exists, return left child
        else
            return leftChildIndex;
    }

    @Override
    public Iterator<T> iterator() {
        return aList.iterator();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<T> iter = iterator();
        while(iter.hasNext()) {
            sb.append(iter.next());
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MyMinHeapVer1<Integer> mh = new MyMinHeapVer1<>();
        mh.insert(3);
        mh.insert(2);
        mh.insert(1);
        mh.insert(0);
        mh.insert(4);
        mh.insert(5);
        mh.insert(-1);
        System.out.println("min: " + mh.extractMin());
        System.out.println(mh.toString());
        System.out.println("min: " + mh.extractMin());
        System.out.println(mh.toString());
        System.out.println("min: " + mh.extractMin());
        System.out.println(mh.toString());
        System.out.println("min: " + mh.extractMin());
        System.out.println(mh.toString());
        System.out.println("min: " + mh.extractMin());
        System.out.println(mh.toString());
    }
}
