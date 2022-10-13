package linked_list;

public class ListNode {
	Object name;
	ListNode link;
	
	public ListNode() {
		link = null;
	}
	
	public ListNode(Object n) {
		name = n;
		link = null;
	}
	
	public void put_name(Object n) {
		name = n;
	}
	
	public Object get_name() {
		return name;
	}
	
	public void put_link(ListNode next) {
		link = next;
	}
	
	public ListNode get_link() {
		return link;
	}
}
