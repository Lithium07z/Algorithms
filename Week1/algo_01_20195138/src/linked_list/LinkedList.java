package linked_list;

public class LinkedList {
	private ListNode firstNode; // ListNode class�� firstNode �ҷ���
	
	public LinkedList() {
		firstNode = null;
	}
	
	public ListNode firstNode() {
		return firstNode; // ù ��° node
	}
	
	public void insert(ListNode p, Object x) { // ���Ḯ��Ʈ ����
		ListNode n = new ListNode(x);
		ListNode temp = p.get_link();
		n.put_link(temp);
		p.put_link(n);
	}
	
	public void append(Object x) { // ���Ḯ��Ʈ ���� �� �߰�
		ListNode n = new ListNode(x);
		ListNode temp = firstNode;
		if (firstNode == null) {
			firstNode = n;
		} else {
			while(true) {
				if (temp.get_link() == null) {
					temp.put_link(n);
					break;
				}
				temp = temp.get_link();
			}
		}
		
	}
	
	public void delete(ListNode p) { // ���Ḯ��Ʈ ���� 
		ListNode temp = p.get_link();
		p.put_link(temp.get_link());
	}
	
	public ListNode listSearch(Object data) {
		ListNode p;
		p = firstNode;
		while (p != null) {
			if (data.equals(p.get_name())) {
				return p;
			}
			p = p.get_link();
		}
		return p; // return null;
	}
	
	public void print() {
		ListNode p;
		System.out.print("(");
		p = firstNode;
		while (p != null) {
			System.out.print(p.get_name());
			p = p.get_link();
			if (p != null) {
				System.out.print(",");
			}
		}
		System.out.print(")");
	}
}
