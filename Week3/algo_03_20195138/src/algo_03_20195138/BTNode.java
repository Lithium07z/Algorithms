package algo_03_20195138;

public class BTNode {
	String data;
	BTNode Lchild;
	BTNode Rchild;
	
	public BTNode() {
		this.Lchild = null; this.data = null; this.Rchild = null;
	}
	
	public BTNode(String dt) {
		this.Lchild = null; this.data = dt; this.Rchild = null;
	}
	
	public BTNode(BTNode lc, String dt, BTNode rc) {
		this.Lchild = lc; this.data = dt; this.Rchild = rc;
	}
}

class BinaryTree {
	BTNode root;
	
	public BinaryTree() {
		root = new BTNode();
	}
	
	public BinaryTree(BinaryTree ltree, String data, BinaryTree rtree) {
		root = new BTNode(ltree.root, data, rtree.root);
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public BinaryTree leftSubTree() {
		return leftSubTree(this.root.Lchild);
	}
	
	private BinaryTree leftSubTree(BTNode n) {
		BinaryTree left;
		BinaryTree right;
		
		if (n.Lchild == null && n.Rchild == null) {
			return new BinaryTree(new BinaryTree(), n.data, new BinaryTree());
		}
		
		left = leftSubTree(n.Lchild);
		right = rightSubTree(n.Rchild);
		
		return new BinaryTree(left, n.data, right);
	}
	
	public BinaryTree rightSubTree() {
		return rightSubTree(this.root.Rchild);
	}
	
	private BinaryTree rightSubTree(BTNode n) {
		BinaryTree left;
		BinaryTree right;
		
		if (n.Lchild == null && n.Rchild == null) {
			return new BinaryTree(new BinaryTree(), n.data, new BinaryTree());
		}
		
		left = leftSubTree(n.Lchild);
		right = rightSubTree(n.Rchild);
		
		return new BinaryTree(left, n.data, right);
	}
	
	public String rootData() {
		return this.root.data;
	}
	
	public void inorder() {
		System.out.println("Inorder");
		theInorder(this.root);
		inorderlter();
	}
	
	private void theInorder(BTNode t) {
		if (t != null && t.data != null) {
			theInorder(t.Lchild);
			System.out.println(t.data);
			theInorder(t.Rchild);
		}
	}
	
	public void preorder() {
		System.out.println("preorder");
		thePreorder(this.root);
		preorderlter();
	}
	
	private void thePreorder(BTNode t) {
		if (t != null && t.data != null) {
			System.out.println(t.data);
			thePreorder(t.Lchild);
			thePreorder(t.Rchild);
		}
	}
	
	public void postorder() {
		System.out.println("postorder");
		thePostorder(this.root);
	}
	
	private void thePostorder(BTNode t) {
		if (t != null && t.data != null) {
			thePostorder(t.Lchild);
			thePostorder(t.Rchild);
			System.out.println(t.data);
		}
	}
	
	private void inorderlter() {
		System.out.println("\nInorderlter");
		Stack stack = new Stack();
		BTNode p = root;
		
		while (p != null || !stack.empty()) {
			if (p != null) {
				stack.push(p);
				p = p.Lchild;
			} else {
				p = (BTNode) stack.pop();
				if (p.data != null) {
					System.out.println(p.data);
				}
				p = p.Rchild;
			}
		}
		// Stack 사용해서 반복문으로 중위순회 구현
	}
	
	private void preorderlter() {
		System.out.println("\npreorderlter");
		Stack stack = new Stack();
		BTNode p = root;
		
		while (p != null || !stack.empty()) {
			if (p != null) {
				if (p.data != null) {
					System.out.println(p.data);
				}
				stack.push(p);
				p = p.Lchild;
			} else {
				p = (BTNode) stack.pop();
				p = p.Rchild;
			}
		}
		// Stack 사용해서 반복문으로 전위순회 구현
	}
	
	public void levelorder() {
		System.out.println("levelorder");
		levelorder(this.root);
		// 반복문, Queue 사용해서 level순회 구현
	}
	
	private void levelorder(BTNode root) {
		Queue q = new Queue();
		BTNode t;
		q.enqueue(root);
		while(!q.isEmpty()) {
			t = (BTNode) q.dequeue();
			if (t.data != null) {
				System.out.println(t.data);
			}
			if (t.Lchild != null) {
				q.enqueue(t.Lchild);
			}
			if (t.Rchild != null) {
				q.enqueue(t.Rchild);
			}
		}
	}
	
	public BinaryTree copy() {
		BinaryTree ctree = new BinaryTree();
		ctree.root = theCopy(this.root);
		return ctree;
		// 주어진 이진트리 복사
	}
	
	private BTNode theCopy(BTNode t) {
		return new BTNode(leftSubTree().root, t.data, rightSubTree().root);
		// private로 복사 구현
	}
	
	public boolean equals(BinaryTree tr) {
		return theEqual(this.root, tr.root);
		// 주어진 두 개의 이진트리의 동등성 결정
	}
	
	private boolean theEqual(BTNode s, BTNode t) {
		if (s.data == null && t.data == null) {
			return true;
		}
		if (!s.data.equals(t.data)) {
			return false;
		}
		return theEqual(s.Lchild, t.Lchild) && theEqual(s.Rchild, t.Rchild);
		// equals 함수를 사용하여 두 개의 이진트리가 동등한지 확인
	}
}
