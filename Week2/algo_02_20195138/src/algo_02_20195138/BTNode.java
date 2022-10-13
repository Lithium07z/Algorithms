package algo_02_20195138;

public class BTNode {
	String data;
	BTNode Lchild;
	BTNode Rchild;
	
	public BTNode(String dt) {
		this.data = dt;
	}
	
	public BTNode(BTNode lc, String dt, BTNode rc) {
		this.Lchild = lc; this.data = dt; this.Rchild = rc;
	}
}

class BinaryTree {
	BTNode root;
	static String temp = "";
	
	public BinaryTree() {
		root = new BTNode(null);
	}
	
	public BinaryTree(BinaryTree ltree, String data, BinaryTree rtree) {
		root = new BTNode(ltree.root, data, rtree.root);
}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public BinaryTree leftSubTree() {
		return leftSubTree(root.Lchild);
	}
	
	private BinaryTree leftSubTree(BTNode n) {
		BinaryTree left;
		BinaryTree right;
		
		if (n.Lchild.data == null && n.Rchild.data == null) {
			return new BinaryTree(new BinaryTree(), n.data, new BinaryTree());
		}
		
		left = leftSubTree(n.Lchild);
		right = rightSubTree(n.Rchild);
		
		return new BinaryTree(left, n.data, right);
	}
	
	public BinaryTree rightSubTree() {
		return rightSubTree(root.Rchild);
	}
	
	private BinaryTree rightSubTree(BTNode n) {
		BinaryTree left;
		BinaryTree right;
		
		if (n.Lchild.data == null && n.Rchild.data == null) {
			return new BinaryTree(new BinaryTree(), n.data, new BinaryTree());
		}
		
		left = leftSubTree(n.Lchild);
		right = rightSubTree(n.Rchild);
		
		return new BinaryTree(left, n.data, right);
	}
	
	public String rootData() {
		return this.root.data;
	}
	
	public int calculate() {
		return Integer.parseInt(calculate(root));
	}
	
	private String calculate(BTNode n) {
		String left = "";
		String right = "";
		
		if (n.Lchild == null && n.Rchild == null) {
			return n.data;
		}
		
		left = calculate(n.Lchild);
		right = calculate(n.Rchild);
		
		if (n.data.equals("+")) {
			return String.valueOf(Integer.parseInt(left) + Integer.parseInt(right));
		} else if (n.data.equals("-")) {
			return String.valueOf(Integer.parseInt(left) - Integer.parseInt(right));
		} else if (n.data.equals("*")) {
			return String.valueOf(Integer.parseInt(left) * Integer.parseInt(right));
		} else if (n.data.equals("/")) {
			return String.valueOf(Integer.parseInt(left) / Integer.parseInt(right));
		}
		return n.data;
	}
}
