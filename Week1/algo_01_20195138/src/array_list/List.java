package array_list;

public class List {
	private int size;
	private int array[];
	private static final int MAX = 100;
	public List() {
		size = 0;
		array = new int[MAX];
	}
	
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public int length() {
		return size;
	}
	
	public int retrieve(int j) { // �� �迭�� �ƴ� ��, j ��°�� ���Ҹ� ���
		if (isEmpty() == true) {
			return -1;
		} else {
			return array[j];
		}
	}
	
	public void replace(int j, int item) { // �� �迭�� �ƴ� ��, j ��° ���� ���� item���� ����
		if (isEmpty() == true) {
			return;
		} else {
			array[j] = item;
		}
	}
	
	public void delete(int j) { // �� �迭�� �ƴ� ��, j ��° ���� ����, �迭 ������ ���� ����
		if (isEmpty() == true) {
			return;
		} else {
			for (int i = j; i < size; i++) {
				array[i] = array[i + 1];
			}
			size--;
		}
	}
	
	public void insert(int j, int k) { // j ��° �ش� ��ġ�� k��� ���� �� �ֱ�
		for (int i = size - 1; i >= j ; i--) {
			array[i + 1] = array[i];
		}
		array[j] = k;
		size++;
	}
}
