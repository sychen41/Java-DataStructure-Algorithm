package DataStructureMyVersion;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Shiyi on 11/3/2016.
 */
public class MyBSTVer1<Key extends Comparable<Key>, Value> implements MyBST<Key, Value> {
    private class Node {
        Key key;
        Value val;
        Node left = null;
        Node right = null;
        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }
    private Node root = null;
    @Override
    public void insert(Key key, Value val) {
        root = insert(root, key, val);
    }
    private Node insert(Node node, Key key, Value val) {
        if (node == null)
            return new Node(key,val);
        else if (key.compareTo(node.key) <= 0)
            node.left = insert(node.left, key, val);
        else
            node.right = insert(node.right, key, val);
        return node;
    }

    @Override
    public boolean contains(Key key) {
        return contains(root, key);
    }

    @Override
    public Value get(Key key) {
        return get(root, key);
    }

    @Override
    public Value delete(Key key) {
        //todo
        return null;
    }

    private Value get(Node node, Key key) {
        if (node==null) throw new NoSuchElementException("key not exist");
        int comp = key.compareTo(node.key);
        if (comp == 0)
            return node.val;
        else if (comp < 0)
            return get(node.left, key);
        else
            return get(node.right, key);
    }

    private boolean contains(Node node, Key key) {
        if (node == null)
            return false;
        int comp = key.compareTo(node.key);
        if (comp == 0)
            return true;
        else if (comp < 0)
            return contains(node.left, key);
        else
            return contains(node.right, key);
    }

    @Override
    public Iterator<Key> iterator() {
        return null;
    }

    @Override
    public String inOrder() {
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString();
    }
    private void inOrder(Node node, StringBuilder sb) {
        if (node != null) {
            inOrder(node.left, sb);
            //System.out.println(node.key);
            sb.append(node.key);
            sb.append(" : ");
            sb.append(node.val);
            sb.append("\n");
            inOrder(node.right, sb);
        }
    }

    public static void main(String[] args) {
        MyBST<Integer,String> bst = new MyBSTVer1<>();
        bst.insert(8, "88");
        bst.insert(4, "44");
        bst.insert(6, "66");
        bst.contains(4);
        System.out.println(bst.inOrder());
        System.out.println(bst.get(4));
    }
}
