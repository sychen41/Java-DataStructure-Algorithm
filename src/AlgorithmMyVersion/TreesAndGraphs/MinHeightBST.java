package AlgorithmMyVersion.TreesAndGraphs;

import java.util.*;

/**
 * Created by Shiyi on 11/5/2016.
 */
public class MinHeightBST implements Iterable<Integer> {

    class Node {
        int data;
        Node left = null;
        Node right = null;
        Node(int data) {
            this.data = data;
        }
    }
    public Node root = null;
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

    //p249 4.6
    /*
    //wrong solution
    class BooleanWrap {
        public boolean flag = false;
    }
    public Node nextOf(Node node) {
        Node[] arr = new Node[1];
        nextOf(node, root, arr, new BooleanWrap());
        return arr[0];
    }

    private void nextOf(Node theNode, Node node, Node[] arr, BooleanWrap found) {
        if (node == null) return;
        nextOf(theNode, node.left, arr, found);
        if (found.flag) {
            arr[0] = node;
            return;
        }
        if (node == theNode) {
            found.flag = true;
            return;
        }
        nextOf(theNode, node.right, arr, found);
    }
    //end of wrong solution
    */

    public String traversalIterative(int type) {
        String str = null;
        switch (type) {
            case 1: str = inOrderIterative(root);
                break;
            case 2: str = preOrderIterative(root);
                break;
            case 3: str = postOrderIterative(root);
            default: inOrderIterative(root);
        }
        return str;
    }

    /*
    1.1 Create an empty stack
    2.1 Do following while root is not NULL
    a) Push root's right child and then root to stack.
    b) Set root as root's left child.
    2.2 Pop an item from stack and set it as root.
    a) If the popped item has a right child and the right child
       is at top of stack, then remove the right child from stack,
       push the root back and set root as root's right child.
    b) Else print root's data and set root as NULL.
    2.3 Repeat steps 2.1 and 2.2 while stack is not empty.
     */
    private String postOrderIterative(Node node) {
        StringBuilder sb = new StringBuilder();
        Stack<Node> st = new Stack<>();
        Node cur = node;
        while(cur!=null) {
            if (cur.right != null)
                st.push(cur.right);
            st.push(cur);
            cur = cur.left;
        }
        while(!st.isEmpty()) {
            Node root = st.pop();
            if (!st.isEmpty() && root.right == st.peek()) {
                Node temp2 = st.pop();
                st.push(root);
                while(temp2!=null) {
                    if (temp2.right!=null)
                        st.push(temp2.right);
                    st.push(temp2);
                    temp2 = temp2.left;
                }
            } else {
                sb.append(root.data + " ");
            }
        }
        return sb.toString();
    }

    private String preOrderIterative(Node node) {
        StringBuilder sb = new StringBuilder();
        Stack<Node> st = new Stack<>();
        st.push(node);
        while(!st.isEmpty()) {
            Node temp = st.pop();
            sb.append(temp.data + " ");
            if (temp.right!=null)
                st.push(temp.right);
            if (temp.left!=null)
                st.push(temp.left);
        }
        return sb.toString();
    }


    /*
    1) Create an empty stack S.
    2) Initialize current node as root
    3) Push the current node to S and set current = current->left until current is NULL
    4) If current is NULL and stack is not empty then
     a) Pop the top item from stack.
     b) Print the popped item, set current = popped_item->right
     c) Go to step 3.
    5) If current is NULL and stack is empty then we are done.
     */
    private String inOrderIterative(Node node) {
        StringBuilder sb = new StringBuilder();
        Stack<Node> st = new Stack<>();
        Node cur = node;
        while(cur != null) {
            st.push(cur);
            cur = cur.left;
        }
        while(!st.isEmpty()) {
            Node temp = st.pop();
            sb.append(temp.data + " ");
            temp = temp.right;
            while(temp != null) {
                st.push(temp);
                temp = temp.left;
            }
        }
        return sb.toString();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MinHeightBSTIter(root);
    }

    private class MinHeightBSTIter implements Iterator<Integer> {
        private Node cur = null;
        private Stack<Node> st = null;
        public MinHeightBSTIter(Node root) {
            st = new Stack<>();
            cur = root;
            while(cur!=null) {
                st.push(cur);
                cur = cur.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !st.isEmpty();
        }

        @Override
        public Integer next() {
            Node result = st.pop();
            Node temp = result.right;
            while(temp!=null) {
                st.push(temp);
                temp = temp.left;
            }
            return result.data;
        }
    }

    public static void main(String[] args) {
        //int[] arr = {1,2,3,7,5,6,4};
        int[] arr = {1,2,3,4,5,6,7};
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
        System.out.println(mhbst.traversalIterative(2));
        for(Integer i: mhbst) {
            System.out.println(i);
        }
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
