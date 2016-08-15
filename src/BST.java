
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
	public void put(Key key, Value value) {
		
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
	public Iterator<Key> iterator() {
		
	}
}
