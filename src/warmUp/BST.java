package warmUp;
/*
public class BST<Key extends Comparable<Key>, Value> {
	private Node root;
	private class Node {
		private Key key;
		private Value val;
		private Node left, right;
		
		public Node(Key key, Value val) {
			this.key = key;
			this.val = val;
		}
	}
	public void put(Key key, Value val) {
		root = put(root, key, val);
	}
	public Node put(Node x, Key key, Value val) {
		if (x==null) return new Node(key,val);
		int cmp = key.compareTo(x.key);
		if 		(cmp<0)
			x.left = put(x.left, key, val);
		else if (cmp>0)
			x.right = put(x.right, key, val);
		else
			x.val = val;
		return x;
	}
	public Value get(Key key) {
		Node x = root;
		while (x!=null) {
			int cmp = key.compareTo(x.key);
			if (cmp>0) x = x.right;
			else if (cmp<0) x = x.left;
			else return x.val;
		}
		return null;
	}
	public void delete(Key key) {
		
	}
	public Key floor(Key key) {
		Node x = floor(root, key);
		if (x==null) return null;
		return x.key;
	}
	public Node floor(Node x, Key key) {
		if (x==null) return null;
		int cmp = key.compareTo(x.key);
		if (cmp==0) return x;
		if (cmp<0) return floor(x.left, key);
		Node t = floor(x.right, key);
		if (t!=null) return t;
		else return x;
	}
	public Iterator<Key> iterator() {
		Queue<Key> q = new Queue<Key>();
		inorder(root, q);
		return q;
	}
	private void inorder(Node x, Queue<Key> q) {
		if (x==null) return;
		inorder(x.left, q);
		q.enqueue(x.key);
		inorder(x.right, q);
	}
}
*/