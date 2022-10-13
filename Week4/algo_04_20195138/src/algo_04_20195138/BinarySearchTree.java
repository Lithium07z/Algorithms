package algo_04_20195138;

class TreeNode {
	String key;
	TreeNode Lchild;
	TreeNode Rchild;
}

public class BinarySearchTree {
	private TreeNode rootNode;
	
	public TreeNode BSTsearch(String K) {
		return BSTsearch(this.rootNode, K);
		// K = 탐색하는 key 값
		// 반복문을 사용하여 key의 위치를 탐색 -> compareTo 함수 사용
	}
	
	private TreeNode BSTsearch(TreeNode n, String K) {
		TreeNode temp = n;
		if (temp == null) {
			return null;
		}
		if (temp.key.equals(K)) {
			return temp;
		}
		if (temp.key.compareTo(K) < 0) {
			return BSTsearch(temp.Rchild, K);
		} else {
			return BSTsearch(temp.Lchild, K);
		}
	}
	
	public void BSTinsert(String K) {
		TreeNode temp = this.rootNode;
		TreeNode parents = null;
		
		while (temp != null) {
			if (K.equals(temp.key)) {
				return;
			}
			parents = temp;
			if (temp.key.compareTo(K) > 0) {
				temp = temp.Lchild;
			} else {
				temp = temp.Rchild;
			}
		}
		
		TreeNode insert = new TreeNode();
		insert.key = K;
		insert.Rchild = null;
		insert.Lchild = null;
		
		if (this.rootNode == null) {
			this.rootNode = insert;
		} else if (parents.key.compareTo(K) > 0) {
			parents.Lchild = insert;
		} else {
			parents.Rchild = insert;
		}
		// 1. K를 key 값으로 가진 원소가 있는지 확인
		// 2. 탐색을 실패하면 반복문이 종료된 위치에 원소를 삽입
	}
	
	
	private TreeNode maxNode(TreeNode root) {
		if (root.Rchild == null) {
			return root;
		}
		return maxNode(root.Rchild);
	}
	
	private TreeNode delete(TreeNode root, String K) {
		TreeNode temp = root;
		TreeNode parents = null;
		
		while (temp != null) {
			if (K.equals(temp.key)) {
				break;
			}
			parents = temp;
			if (temp.key.compareTo(K) > 0) {
				temp = temp.Lchild;
			} else {
				temp = temp.Rchild;
			}
		}
		
		if (temp == null) {
			return null;
		}
		if (temp.Lchild == null && temp.Rchild == null) {
			if (temp == root) {
				return null;
			}
			if (parents.Lchild == temp) {
				parents.Lchild = null;
			} else {
				parents.Rchild = null;
			}
		} else if (temp.Lchild == null || temp.Rchild == null) {
			if (temp == root) {
				if (temp.Lchild == null) {
					temp = temp.Rchild;
				} else {
					temp = temp.Lchild;
				}
			}
			if (temp.Lchild != null) {
				if (parents.Lchild == temp) {
					parents.Lchild = temp.Lchild;
				} else {
					parents.Rchild = temp.Lchild;
				}
			} else {
				if (parents.Lchild == temp) {
					parents.Lchild = temp.Rchild;
				} else {
					parents.Rchild = temp.Rchild;
				}
			}
		} else if ((temp.Lchild != null) && (temp.Rchild != null)) {
			TreeNode max = maxNode(temp.Lchild);
			temp.key = max.key;
			temp.Lchild = delete(temp.Lchild, temp.key);
		}
		return root;
		// 1. 자식이 없는 리프 노드일 때
		// 2. 자식이 하나인 노드일 때 ->
		// 자식을 삭제되는 노드 자리에 넣기
		// 3. 자식이 둘인 노드일 때 ->
		// maxNode를 사용하여 삭제되는 노드 자리에 왼쪽 서브트리에서 가장 큰 값 넣기
	}
	
	public void BSTdelete(String K) {
		this.rootNode = delete(this.rootNode, K);
	}
	
	public boolean BSTsplit(String x, BinarySearchTree SmallTree, BinarySearchTree LargeTree) {
		TreeNode Small = new TreeNode();
		TreeNode Large = new TreeNode();
		TreeNode S = Small;
		TreeNode L = Large;
		TreeNode P = this.rootNode;
		
		while (P != null) {
			if (x.equals(P.key)) {
				S.Rchild = P.Lchild;
				L.Lchild = P.Rchild;
				SmallTree.rootNode = Small.Rchild;
				LargeTree.rootNode = Large.Lchild;
				return true;
			} else if (P.key.compareTo(x) > 0) {
				L.Lchild = P;
				L = P;
				P = P.Lchild;
			} else {
				S.Rchild = P;
				S = P;
				P = P.Rchild;
			}
		}
		SmallTree.rootNode = Small.Rchild;
		LargeTree.rootNode = Large.Lchild;
		return false;
	}
	
	private void printNode(TreeNode n) {
		if (n != null) {
			System.out.print("(");
			printNode(n.Lchild); 
			System.out.print(" " + n.key + " ");
			printNode(n.Rchild);
			System.out.print(")");
		}
	}
	
	public void print() {
		printNode(this.rootNode);
		System.out.println();
	}
}
