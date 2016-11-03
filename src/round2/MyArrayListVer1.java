package round2;

import java.lang.reflect.Array;
import java.util.Iterator;

/**
 * Created by Shiyi on 11/2/2016.
 */
public class MyArrayListVer1<T> implements MyArrayList<T> {
    private T[] arr;
    private int currentIndex = 0;
    private int size = 0;
    private static int capacity = 2;
    private Class<T> cla;
    public MyArrayListVer1(Class<T> clazz) {
        //arr = (T[]) new Object[capacity];
        cla = clazz;
        arr = (T[]) Array.newInstance(cla, capacity);
    }
    @Override
    public void add(T item) {
        if (currentIndex >= capacity) {
            T[] newArr = (T[]) Array.newInstance(cla, capacity*2);
            for(int i=0;i<capacity;i++)
                newArr[i] = arr[i];
            arr = newArr;
            capacity*=2;
        }
        arr[currentIndex++] = item;
        size++;
    }

    @Override
    public void add(T item, int index) {
        if (index >= capacity) throw new IndexOutOfBoundsException();
        add(item);//call add in case resizing needed.
        /*
        T oldElementAtIndex = arr[index];
        T[] newArr = (T[]) Array.newInstance(cla, capacity);
        for(int i=0;i<index;i++)
            newArr[i] = arr[i];
        newArr[index] = item;
        for(int i=index+1;i<size;i++)
            newArr[i] = arr[i-1];
        arr = newArr;
        */
        for(int i=size-1;i>index;i--)
            arr[i] = arr[i-1];
        arr[index] = item;
    }

    @Override
    public boolean contains(T item) {
        for(int i=0;i<size;i++){
            if(arr[i].equals(item)) return true;
        }
        return false;
    }

    @Override
    public void remove(int index) {
        if (index>=size) throw new IndexOutOfBoundsException();
        /*
        T[] newArr = (T[]) Array.newInstance(cla, capacity);
        for(int i=0;i<index;i++)
            newArr[i] = arr[i];
        for(int i=index;i<size-1;i++)
            newArr[i] = arr[i+1];
        arr = newArr;
        */
        for(int i=index;i<size;i++)
            arr[index] = arr[index+1];
        size--;
        currentIndex--;
    }

    @Override
    public T get(int index) {
        if (index >= size) throw new IndexOutOfBoundsException();
        return arr[index];
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayListVer1Iter();
    }

    private class MyArrayListVer1Iter implements Iterator<T> {
        private int current = 0;
        @Override
        public boolean hasNext() {
            return current!=size;
        }

        @Override
        public T next() {
            return arr[current++];
        }
    }
}
