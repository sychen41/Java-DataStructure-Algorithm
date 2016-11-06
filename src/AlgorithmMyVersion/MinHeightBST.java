package AlgorithmMyVersion;

import DataStructureMyVersion.MyBSTVer1;
import warmUp.Parent;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Shiyi on 11/5/2016.
 */
public class MinHeightBST {
    class Node {
        int data;
        Node left = null;
        Node right = null;
        Node(int data) {
            this.data = data;
        }
    }
    private Node root = null;
    private int[] arr = null;
    private int height = 1;
    public int getHeight() {
        return height;
    }
    public MinHeightBST(int[] arr) {
        this.arr = arr;
        this.root = process(0, arr.length-1);
    }

    /*
    //p110 4.4
    private Node process(int start, int end) {
        Node temp = new Node(arr[start++]);
        if (start<=end)
            temp.right = process(start, end);
        return temp;
    }
    //end of 4.4
    */
    //p109 4.2
    private Node process(int start, int end) {
        int middle = start + (end - start + 1)/2;
        Node temp = new Node(arr[middle]);
        if (middle>start)
            temp.left = process(start, middle - 1);
        if (middle<end)
            temp.right = process(middle + 1, end);
        return temp;
    }
    //end of 4.2

    //p109 4.3 // method 1: BFS
    public ArrayList<LinkedList<Integer>> listOfDepth() {
        class NodeAndDepth {
            Node node;
            int depth;
            NodeAndDepth(Node node, int depth) {
                this.node = node;
                this.depth = depth;
            }
        }
        Node current = root;
        ArrayList<LinkedList<Integer>> alist = new ArrayList<>();
        Queue<NodeAndDepth> q = new LinkedList<>();
        q.add(new NodeAndDepth(current, 0)); // 0 stands for the 0th level (root)
        alist.add(new LinkedList<>());
        int currentDepth = 0;
        while(!q.isEmpty()) {
            NodeAndDepth temp = q.remove();
            if (currentDepth==temp.depth)
                alist.get(currentDepth).add(temp.node.data);
            else {
                currentDepth = temp.depth;
                alist.add(new LinkedList<>());
                alist.get(currentDepth).add(temp.node.data);
            }
            if (temp.node.left!=null)
                q.add(new NodeAndDepth(temp.node.left, currentDepth+1));
            if (temp.node.right!=null)
                q.add(new NodeAndDepth(temp.node.right, currentDepth+1));
        }
        return alist;
    }

    //p109 4.3 // method 2: tree traversal (doesn't matter which way to traversal)
    ArrayList<LinkedList<Integer>> listOfDepth = null;
    public ArrayList<LinkedList<Integer>> listOfDepth2 () {
        listOfDepth = new ArrayList<>();
        listOfDepth.add(new LinkedList<>());
        preOrder(root, 0);
        return listOfDepth;
    }
    private void preOrder(Node node, int level) {
        if (node==null) return;
        visit(node, level);
        preOrder(node.left, level+1);
        preOrder(node.right, level+1);
    }

    private void visit(Node node, int level) {
        if (level<listOfDepth.size())
            listOfDepth.get(level).add(node.data);
        else {
            listOfDepth.add(new LinkedList<>());
            listOfDepth.get(level).add(node.data);
        }
    }
    //end of 4.3

    //p110 4.4
    /*
    //1st solution
    public boolean checkIfBalance() {
        try {
            checkHeight(root);
            return true;
        }
        catch(Exception e) {
            if (e.getMessage().equals("Not a balanced tree"))
                return false;
            else
                System.out.println(e.getMessage());
        }
        return false;
    }

    private int checkHeight(Node node) throws Exception {
        if (node==null) return -1;
        int leftDepth = 1 + checkHeight(node.left);
        int rightDepth = 1 + checkHeight(node.right);
        if (Math.abs(leftDepth-rightDepth) > 1) {
            throw new Exception("Not a balanced tree");
        }
        return leftDepth>=rightDepth ? leftDepth : rightDepth;
    }
    */
    //2nd solution
    public boolean checkIfBalance() {
        return checkHeight(root) != Integer.MIN_VALUE;
    }
    private int checkHeight(Node node) {
        if (node==null) return -1;
        int leftHeight = checkHeight(node.left);
        // use error code Integer.MIN_VALUE as a special stopping criteria, and pass it up
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        int rightHeight = checkHeight(node.right);
        // use error code Integer.MIN_VALUE as a special stopping criteria, and pass it up.
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if (Math.abs(leftHeight - rightHeight) > 1)
            // generate an error code and return it instead of the real height
            return Integer.MIN_VALUE;
        return Math.max(leftHeight, rightHeight) + 1;
    }
    //end of 4.4

    //p245 4.5
    /*
    //wrong solution 1. Counter Example: p247 middle graph
    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root);
    }

    private boolean isBinarySearchTree(Node node) {
        if (node==null) return true;
        boolean isBST = true;
        isBST = isBSTNode(node);
        if (!isBST) return false;
        isBST = isBinarySearchTree(node.left);
        if (!isBST) return false;
        isBST = isBinarySearchTree(node.right);
        if (!isBST) return false;
        return isBST;
    }

    private boolean isBSTNode(Node node) {
        if (node.left!=null)
            if (node.data < node.left.data) // left should be < or = the node
                return false;
        if (node.right!=null)
            if (node.data >= node.right.data) // right should be strictly > the node
                return false;
        return true;
    }
    //end of wrong solution 1
    */
    /*
    //wrong solution 2: counter example: root = Integer.MAX_VALUE
    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node node, int min, int max) {
        //null case
        if (node == null) return true;
        //base case
        if (min > node.data || max <= node.data) return false;
        //recursion part
        if (!isBinarySearchTree(node.left, min, node.data))
            // early exit (no need to continue recursion call)
            return false;
        if (!isBinarySearchTree(node.right, node.data, max))
            return false;
        //recursion return
        return true;
    }
    //end of wrong solution 2
    */
    //right solution
    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, null, null);
    }

    private boolean isBinarySearchTree(Node node, Integer min, Integer max) {
        //null case
        if (node == null) return true;
        //base case
        if ((min!= null && min > node.data)
                || (max!=null && max <= node.data))
            return false;
        //recursion part
        if (!isBinarySearchTree(node.left, min, node.data))
            // early exit (no need to continue recursion call)
            return false;
        if (!isBinarySearchTree(node.right, node.data, max))
            return false;
        //recursion return
        return true;
    }
    //end of right solution
    //end of 4.5


    public static void main(String[] args) {
        int[] arr = {1,2,3,7,5,6,4};
        MinHeightBST mhbst = new MinHeightBST(arr);
        ArrayList<LinkedList<Integer>> listOfDepth = mhbst.listOfDepth();
        listOfDepth.forEach(
                list->{
                    list.forEach(
                            num->System.out.print(num+" ")
                    );
                    System.out.println("\nend of one level");
                }
        );
        if (mhbst.isBinarySearchTree())
            System.out.println("is BST");
        else
            System.out.println("not BST");
        /*
        for(LinkedList<Integer> list: listOfDepth) {
            list.forEach(e->System.out.print(e + " "));
            System.out.println("\nend of one level");
        }
        */


        /*
        // use this and the first process() for p110 4.4
        int[] arr = {1,2,3};
        MinHeightBST mhbst = new MinHeightBST(arr);
        ArrayList<LinkedList<Integer>> listOfDepth2 = mhbst.listOfDepth2();
        for(LinkedList<Integer> list: listOfDepth2) {
            //list.forEach(System.out::println);
            list.forEach(e->System.out.print(e + " "));
            System.out.println("\nend of one level");
        }
        if (mhbst.checkIfBalance()) System.out.println("balanced");
        else System.out.println("not balanced");
        */
    }
}
