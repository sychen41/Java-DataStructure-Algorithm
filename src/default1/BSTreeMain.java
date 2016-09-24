package default1;

/**
 * Created by Shiyi on 9/22/2016.
 */
public class BSTreeMain {
    public static void main(String[] args) {
        BSTree bst = new BSTree(100);
        bst.insert(50);
        bst.insert(25);
        bst.insert(15);
        bst.insert(75);
        bst.insert(85);
        bst.insert(185);
        bst.insert(125);
        bst.insert(150);
        bst.insert(200);
        bst.insert(65);
        bst.treeTraversal(3);
        System.out.println(bst.contains(15));
        //bst.delete(15);
        bst.treeTraversal(3);
        System.out.println(bst.contains(15));
        //bst.contains(63);

    }
}
