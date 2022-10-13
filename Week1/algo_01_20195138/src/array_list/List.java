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
	
	public int retrieve(int j) { // 빈 배열이 아닐 때, j 번째의 원소를 출력
		if (isEmpty() == true) {
			return -1;
		} else {
			return array[j];
		}
	}
	
	public void replace(int j, int item) { // 빈 배열이 아닐 때, j 번째 원소 값을 item으로 변경
		if (isEmpty() == true) {
			return;
		} else {
			array[j] = item;
		}
	}
	
	public void delete(int j) { // 빈 배열이 아닐 때, j 번째 원소 삭제, 배열 사이즈 감소 주의
		if (isEmpty() == true) {
			return;
		} else {
			for (int i = j; i < size; i++) {
				array[i] = array[i + 1];
			}
			size--;
		}
	}
	
	public void insert(int j, int k) { // j 번째 해당 위치에 k라는 원소 값 넣기
		for (int i = size - 1; i >= j ; i--) {
			array[i + 1] = array[i];
		}
		array[j] = k;
		size++;
	}
}
