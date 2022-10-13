package algo_04_20195138;

public class BSTTest {
	public static void main(String[] args) {
		BinarySearchTree t = new BinarySearchTree();
		t.BSTinsert("S");
		t.BSTinsert("J");
		t.BSTinsert("B");
		t.BSTinsert("D");
		t.BSTinsert("U");
		t.BSTinsert("M");
		t.BSTinsert("R");
		t.BSTinsert("Q");
		t.BSTinsert("A");
		t.BSTinsert("G");
		t.BSTinsert("E");

		t.print();
	
		TreeNode n = t.BSTsearch("R");
		if (n == null) {
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.BSTdelete("R");

		n = t.BSTsearch("R");
		if (n == null) {
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.print();

		System.out.println("=====================================E=====================================");

		n = t.BSTsearch("E");
		if (n == null) {
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.BSTdelete("E");

		n = t.BSTsearch("E");
		if (n == null) {
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.print();

		System.out.println("=====================================J=====================================");

		n = t.BSTsearch("J");
		if (n == null) {
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.BSTdelete("J");

		n = t.BSTsearch("J");
		if (n == null) {
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.print();

		System.out.println("=====================================S=====================================");

		n = t.BSTsearch("S");
		if (n == null) {
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.BSTdelete("S");

		n = t.BSTsearch("S");
		if (n == null) {
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.print();

		System.out.println("=====================================B=====================================");

		n = t.BSTsearch("B");
		if (n == null) {
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.BSTdelete("B");

		n = t.BSTsearch("B");
		if (n == null) {
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.print();

		System.out.println("=====================================C=====================================");

		n = t.BSTsearch("C");
		if (n == null) {
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.BSTdelete("C");

		n = t.BSTsearch("C");
		if (n == null) {
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}
		
		t.print();
		
		System.out.println("=====================================new=====================================");
		
		BinarySearchTree t1 = new BinarySearchTree();
		t1.BSTinsert("S");
		t1.BSTinsert("J");
		t1.BSTinsert("B");
		t1.BSTinsert("D");
		t1.BSTinsert("U");
		t1.BSTinsert("M");
		t1.BSTinsert("R");
		t1.BSTinsert("Q");
		t1.BSTinsert("A");
		t1.BSTinsert("G");
		t1.BSTinsert("E");
		
		t1.print();
		
		System.out.println("=====================================split=====================================");
		
		BinarySearchTree Small = new BinarySearchTree();
		BinarySearchTree Large = new BinarySearchTree();
	
		t1.BSTsplit("D", Small, Large);
	
		Small.print();
		Large.print();
		
		t1.BSTsplit("R", Small, Large);
		
		Small.print();
		Large.print();
	}
}
