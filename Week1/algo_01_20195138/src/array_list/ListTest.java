package array_list;

public class ListTest {
	public static void main(String[] args) {
		List ia;
		ia = new List();
		System.out.println(ia.isEmpty());
		System.out.println(ia.length());
		ia.insert(0, 3);
		ia.insert(1, 5);
		ia.insert(2, 4);
		ia.insert(3, 2);
		ia.insert(4, 7);
		System.out.println(ia.isEmpty());
		System.out.println(ia.length());
		System.out.println(ia.retrieve(2));
		ia.replace(2, 3);
		ia.insert(2, 2);
		System.out.println(ia.length());
		ia.delete(1);
		ia.insert(2, 7);
		System.out.println(ia.length());
		System.out.println(ia.retrieve(2));
		System.out.println(ia.retrieve(4));
	}
}
