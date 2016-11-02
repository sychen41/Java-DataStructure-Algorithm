package round1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Shiyi on 9/24/2016.
 */
public class MaxHeap<E extends Comparable<E>> implements Iterable<E> {
    private ArrayList<E> alist; // for index i: parents are: (i+1)*2-1 and (i+1)*2
                                                // child is (i+1)/2-1
    public MaxHeap() {
        alist = new ArrayList<E>();
    }
    public int size() {return alist.size();}
    public boolean isEmpty() {return alist.isEmpty();}

    public void add(E e) {
        int index = alist.size();
        alist.add(e);
        siftUp(index);
    }
    private void siftUp(int index) {
        while(index>0) {
            int childIndex = getChildIndex(index);
            if(comp(alist.get(index), alist.get(childIndex))>0) {
                exchange(index, childIndex);
                index = childIndex;
            } else {
                break;
            }
        }
    }
    public E deleteMax() {
        E max = alist.get(0);
        alist.set(0,alist.get(size()-1)); // replace the first element with the last element
        alist.remove(alist.size()-1); // delete the last element
        siftDown(0);
        return max;
    }
    private void siftDown(int index) {
        while(index < alist.size()/2) {
            int[] parentsIndex = getParentsIndex(index);
            // it has two parents
            if (parentsIndex[1] < alist.size()) {
                int largerParentIndex = comp(alist.get(parentsIndex[0]), alist.get(parentsIndex[1]))>0 ? parentsIndex[0] : parentsIndex[1];
                // it's smaller than the larger parent, switch it with the larger parent
                if (comp(alist.get(index), alist.get(largerParentIndex))<0) {
                    exchange(index, largerParentIndex);
                    index = largerParentIndex;
                }
                // it's larger than the larger parent, end sift down process
                else break;
            }
            // it has only one parent
            else {
                // it's smaller than the only parent, switch them.
                if (comp(alist.get(index), alist.get(parentsIndex[0]))<0) { // it's smaller than the only parent
                    exchange(index, parentsIndex[0]);
                    index = parentsIndex[0];
                }
                // it's larger than the only parent, end sift down process.
                else break;
            }
            // it's impossible to have no parent, otherwise, index < alist.size() will be false
        }
    }
    private int getChildIndex(int index) {
        return (index+1)/2-1;
    }
    private int[] getParentsIndex(int index) {
        int[] temp = {(index+1)*2-1, (index+1)*2};
        return temp;
    }
    private int comp(E e1, E e2) {
        return e1.compareTo(e2);
    }
    private void exchange(int pos1, int pos2) {
        E temp = alist.get(pos1);
        alist.set(pos1, alist.get(pos2));
        alist.set(pos2, temp);
    }
    public Iterator<E> iterator() {
        return new MaxHeapIterator();
    }

    private class MaxHeapIterator implements Iterator<E> {
        private int currentIndex = 0;
        @Override
        public boolean hasNext() {
            return currentIndex < alist.size();
        }
        @Override
        public E next() {
            E temp = alist.get(currentIndex);
            currentIndex++;
            return temp;
        }
    }
}

