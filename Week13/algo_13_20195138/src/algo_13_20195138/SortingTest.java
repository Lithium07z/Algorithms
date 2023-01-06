package algo_13_20195138;

public class SortingTest {
	public static void main(String[] args) {
		int test[] = {3, 1, 4, 5, 9, 8, 7};
		Sorting.quickSort(test);
		
		for (int i = 0; i < test.length; i++) {
			System.out.print(test[i] + " ");
		}
		
		System.out.println();
		
		int test2[] = {0, 2, 4, 5, 7, 3, 10, 8, 1, 9, 6};
		Sorting.mergeSort(test2);
		
		System.out.println();
		
		for (int i = 0; i < test2.length; i++) {
			System.out.print(test2[i] + " ");
		}
	}
}

class Sorting {
	public static void quickSort(int[] a) {
		// 퀵 정렬의 메인 메소드
		theQuickSort(a, 0, a.length - 1); // a배열의 0부터 a.length - 1까지 값을 정렬
	}
	
	private static void theQuickSort(int[] a, int left, int right) {
		// quickSort()의 보조 메소드
		int p;
		if (left > right) {
			return;
		}
		p = partition(a, left, right);
		theQuickSort(a, left, p - 1);
		theQuickSort(a, p + 1, right);
	}
	
	private static int partition(int[] a, int i, int j) {
		int middle = (i + j) / 2;
		int pivot = a[middle];
		int p;
		swap(a, middle, i);
		p = i;
		for (int k = i + 1; k <= j; k++) {
			if (a[k] < pivot) {
				p++;
				swap(a, p, k);
			}
		}
		swap(a, i, p);
		return p;
	}
	
	private static void swap(int[] a, int j, int k) {
		int temp = a[j];
		a[j] = a[k];
		a[k] = temp;
	}
	
	public static void mergeSort(int[] a) {
		// 합병 정렬의 메인 메소드 
		int temp[] = new int[a.length]; // 복사에 사용할 임시 배열
		theMergeSort(a, temp, 0, a.length - 1); // 원본 배열 a, 복사 할 배열 temp를 0부터 a.lenght - 1까지 정렬
	}
	
	private static void theMergeSort(int[] a, int[] temp, int left, int right) {
		// 순환 호출을 하는 mergeSort()의 보조 메소드
		if (left < right) {
			int middle = (left + right) / 2;
			theMergeSort(a, temp, left, middle);
			theMergeSort(a, temp, middle + 1, right);
			merge(a, temp, left, middle, middle + 1, right);
		}
	}
	
	private static void merge(int[] a, int[] temp, int m, int p, int q, int n) {
		// theMergeSort의 보조 메소드
		int t = m;
		int num = n - m + 1;
		while (m <= p && q <= n) {
			if (a[m] < a[q]) { // 나뉘어진 두 배열의 값 중 더 작은 쪽을 임시배열에 저장
				temp[t++] = a[m++];
			} else {
				temp[t++] = a[q++];
			}
		}
		while (m <= p) { // q가 범위를 벗어난 경우
			temp[t++] = a[m++];
		}
		while (q <= n) { // m이 범위를 벗어난 경우 
			temp[t++] = a[q++];
		}
		for (int i = 0; i < num; i++, n--) {
			a[n] = temp[n];
		}
	}
}
