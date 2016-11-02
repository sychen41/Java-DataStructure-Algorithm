package round1;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by Shiyi on 9/24/2016.
 */
public class MaxHeapMain {
    public static void main(String[] args) {
        MaxHeap<Integer> mh = new MaxHeap<>();
        Iterator<Integer> iter = mh.iterator(); //the behavior of this iterator is like ArrayList's, not like BST2's
                                                //for the iterator comparison, refer to BST2Main.
        System.out.println(iter.hasNext());
        mh.add(0);
        System.out.println(iter.hasNext());

        /*ArrayList<Integer> alist = RandomWoDup.listRange(10,20);
        System.out.println(alist.toString());
        for(Integer i: alist) mh.add(i);
        */

        /*
        int[] arr = RandomWoDup.arrRange(100,110); //110 is excluded
        System.out.println(Arrays.toString(arr));
        for(Integer i: arr) mh.add(i);
        */

        Set<Integer> set = RandomWoDup.nRandomNums(10);
        System.out.println(set.toString());
        for(Integer i: set) mh.add(i);
        for(Integer i: mh) System.out.print(i + " ");
        System.out.println();
        //heap sort
        while(!mh.isEmpty())
            System.out.println(mh.deleteMax());
        //for(Integer i: mh) System.out.print(i + " ");
        //System.out.println();
            //System.out.println(mh.deleteMax());
        //for(Integer i: mh) System.out.println(i);
        //System.out.println(Arrays.toString(RandomWoDup.arrRange(1,10)));
    }
}
