package linked_list;

public class LinkedListTest {
	public static void main(String args[]) {
		LinkedList l = new LinkedList();
		
		l.append("Kim");
		l.append("Lee");
		l.append("Park");
		l.print();
		l.append("Yoo");
		l.print();
		
		ListNode n = l.listSearch("Lee");
		
		l.insert(n, "Choi");
		l.print();
		l.delete(n);
		l.print();
		
		n = l.listSearch("Yoo");
		l.insert(n, "Choi");
		l.print();
	}
}
