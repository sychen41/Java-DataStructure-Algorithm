package AlgorithmMyVersion.TreesAndGraphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Shiyi on 11/4/2016.
 */
public class GraphMyVer1 {
    private class Node {
        String name;
        boolean marked = false;
        Node[] neighbors = null;
        Node(String name) {
            this.name = name;
        }
        void addNeighbors(Node[] neighbors) {
            this.neighbors = neighbors;
        }
    }

    public Node[] nodes;
    public GraphMyVer1() {
        nodes = new Node[]{new Node("0"), new Node("1"), new Node("2"),
                        new Node("3"), new Node("4"), new Node("5") };
        nodes[0].addNeighbors(new Node[]{nodes[1], nodes[4], nodes[5]});
        nodes[1].addNeighbors(new Node[]{nodes[3], nodes[4]});
        nodes[2].addNeighbors(new Node[]{nodes[1]});
        nodes[3].addNeighbors(new Node[]{nodes[2], nodes[4]});
        nodes[4].addNeighbors(new Node[]{});
        nodes[5].addNeighbors(new Node[]{});
    }

    // theory practice
    public void depthFirstSearch(Node node) {
        if (node==null) return;
        //if (!node.marked) {
        visit(node);
        node.marked = true;
        //}
        for(Node neighbor: node.neighbors) {
            if (!neighbor.marked)
                depthFirstSearch(neighbor);
        }
    }

    public void depthFirstSearchUsingStack(Node node) {
        Stack<Node> st = new Stack<>();
        st.push(node);
        node.marked = true; //visited
        while(!st.isEmpty()) {
            Node current = st.pop();
            visit(current);
            for (Node neighbor: current.neighbors) {
                if(!neighbor.marked)
                    st.push(neighbor);
                    neighbor.marked = true; //visited
            }
        }
    }

    public void breathFirstSearch(Node node) {
        Queue<Node> q = new LinkedList<>();
        node.marked = true;  // easy to miss this line
        q.add(node);
        while(!q.isEmpty()) {
            Node current = q.remove(); //dequeue
            visit(current);
            for(Node neighbor: current.neighbors) {
                if (!neighbor.marked) {
                    neighbor.marked = true; //visited
                    q.add(neighbor); //enqueue
                }
            }
        }
    }

    private void visit(Node node) {
        System.out.println(node.name);
    }

    // problem solving
    public boolean isThereAPath(Node a, Node b) {
        return isReachable(a, b) || isReachable(b, a);
    }

    private boolean isReachable(Node source, Node target) {
        HashSet<Node> visited = new HashSet<>();
        // BFS
        Queue<Node> q = new LinkedList<>();
        q.add(source);
        visited.add(source);
        while(!q.isEmpty()) {
            Node current = q.remove();
            if (current.equals(target)) return true;
            for(Node neighbor: current.neighbors) {
                if (!visited.contains(neighbor)) {
                    q.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        GraphMyVer1 g = new GraphMyVer1();
        //g.depthFirstSearch(g.nodes[0]);
        //g.depthFirstSearchUsingStack(g.nodes[0]);
        //g.breathFirstSearch(g.nodes[0]);
        //if (g.isThereAPath(g.nodes[1], g.nodes[4]))
        //    System.out.println("1 4 reachable");
    }

}
