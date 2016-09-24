package default1;

import java.util.Iterator;

/**
 * Created by Shiyi on 9/23/2016.
 */
public class BST2Main {
    public static void main(String[] args) {
        BST2<Integer, String> bst = new BST2<>();
        bst.put(100,"100 Secret");
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

        // because BST2 implements Iterable
        for(String val: bst)
            System.out.println("val: " + val);
        System.out.println("-------------------");
        // because BST has a method that creates an iterator
        Iterator<String> iter = bst.iterator();
        while(iter.hasNext())
            System.out.println("iter: " + iter.next());

    }
}
