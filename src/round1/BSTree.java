package round1;

/**
 * Created by Shiyi on 9/22/2016.
 */
public final class BSTree {
    private static class Node {
        int data;
        Node left;
        Node right;
        Node() {
            data = 0;
            left = null;
            right = null;
        }
        Node(int data ) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    private Node root;
    public BSTree() {
        root = new Node();
    }
    public BSTree(int root) {
        this.root = new Node(root);
    }
    public void insert(int data) {
        root = insert(root, data);
    }
    public Node insert(Node node, int data) {
        if (node == null) node = new Node(data);
        else {
            if (data <= node.data) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
        }
        return node;
    }
    public boolean contains(int data) {
        return locate(root, data) != null;
    }
    private Node locate(Node node, int data) {
        if (node == null) return null;
        else if (node.data == data) return node;
        else {
            if (data < node.data)
                return locate(node.left, data);
            else //(node.data > data)
                return locate(node.right, data);
        }
    }
    //public void set(int data, int newData) {
    //    locate(root, data).data = newData;
    //}

    /*
    //unfinished
    public boolean delete(int data) {
        if (!contains(data)) return false;
        else {
            Node toBeDelete = locate(root, data);
            if (toBeDelete.right == null && toBeDelete.left == null) {
                toBeDelete.data = 0;
            }
            return true;
        }
    }
    */
    public Node leftMostChild(Node node) {
        if (node.left == null) return node;
        else return leftMostChild(node.left);
    }
    /*public void insert(int data) {
        insert(root, data);
    }
    private void insert(Node node, int data) {
        if (data <= node.data) {
            if (node.left!=null)
                insert(node.left, data);
            else
                node.left = new Node(data);
        } else {
            if (node.right!=null)
                insert(node.right, data);
            else
                node.right= new Node(data);
        }
    }
    */
    public void treeTraversal(int type) {
        switch (type) {
            case 1:
                preOrderTraversal(root);
                break;
            case 2:
                inOrderTraversal(root);
                break;
            case 3:
                postOrderTraversal(root);
                break;
            default:
                throw new IllegalArgumentException("valid types are: 1(pre order) 2(in order) 3(post order)");
        }
    }
    private void preOrderTraversal(Node node) {
        System.out.println(node.data);
        if (node.left!=null)
            preOrderTraversal(node.left);
        if (node.right!=null)
            preOrderTraversal(node.right);
    }
    private void inOrderTraversal(Node node) {
        if (node.left!=null)
            inOrderTraversal(node.left);
        System.out.println(node.data);
        if (node.right!=null)
            inOrderTraversal(node.right);
    }
    private void postOrderTraversal(Node node) {
        if (node.left!=null)
            postOrderTraversal(node.left);
        if (node.right!=null)
            postOrderTraversal(node.right);
        System.out.println(node.data);
    }

    public int printRoot() {
        return root.data;
    }
}
