package default1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Shiyi on 9/23/2016.
 */
public class BST2Main {
    public static void main(String[] args) {
        BST2<Integer, String> bst = new BST2<>();
        bst.put(100,"100 Secret");
        /*
        bst.put(50,"50 Secret");
        bst.put(185,"185 Secret");
        bst.put(25,"25 Secret");
        bst.put(75,"75 Secret");
        bst.put(125,"125 Secret");
        bst.put(200,"200 Secret");
        bst.put(15,"15 Secret");
        bst.put(65,"65 Secret");
        bst.put(85,"85 Secret");
        bst.put(150,"150 Secret");
        bst.put(70,"70 Secret");
        //bst.treeTraversal(2);
        System.out.println("-------------------");
        bst.delete(15);
        //bst.treeTraversal(2);
        System.out.println("-------------------");
        bst.delete(50);
        //bst.treeTraversal(2);
        System.out.println("-------------------");
        //bst.put(50, "new Secret");
        bst.treeTraversal(2);
        System.out.println("-------------------");
        bst.delete(51); //no effect
        */

        // because BST2 implements Iterable
        for(String val: bst)
            System.out.println("val: " + val);
        System.out.println("-------------------");
        // because BST has a method that creates an iterator
        Iterator<String> iter = bst.iterator();
        //while(iter.hasNext())
        //    System.out.println("iter: " + iter.next());
        System.out.println("BST2's iterator behavior: ");
        System.out.println(iter.hasNext());
        System.out.println(iter.next());
        System.out.println(iter.hasNext()); // false
        bst.put(500, "500 Secret"); // this won't make the hasNext true again. so you always need to reinitialize
                                    // the iterator (by calling bst.iterator() after the tree is updated;
        System.out.println(iter.hasNext()); // so still false

        System.out.println("ArrayList's iterator behavior: ");
        ArrayList<Integer> alist = new ArrayList<>();
        Iterator<Integer> iterAlist = alist.iterator();
        System.out.println(iterAlist.hasNext()); //false
        alist.add(10); //UNLIKE BST2's iterator, ArrayList 's iterator now will have next;
        System.out.println(iterAlist.hasNext()); //false

    }
}
