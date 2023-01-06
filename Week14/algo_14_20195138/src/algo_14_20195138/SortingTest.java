package algo_14_20195138;

class Sorting {
	
	public static void heapSort(int[] a) {
		int n  = a.length - 1; // n은 heap 크기(원소의 수)
		
		for (int i = n / 2; i >= 1; i--) {
			heapify(a, i, n);
		}
		
		for (int i = n - 1; i >= 1; i--) {
			int temp = a[1];
			a[1] = a [i + 1];
			a[i + 1] = temp;
			heapify(a, 1, i);
		}
	}
	
	private static void heapify(int[] a, int h, int m) {
		// 루트 h를 제외한 h의 왼쪽 서브트리와 오른쪽 서브트리는 heap
		// 현재 시점으로 노드의 최대 레벨 순서 번호는 m
		int ah = a[h];
		int j = 0;
		for (j = 2 * h; j <= m; j *= 2) {
			if (j < m && a[j] < a[j + 1]) {
				j += 1;
			}
			if (ah >= a[j]) {
				return;
			} else {
				a[j / 2] = a[j];
			}
		}
		a[j / 2] = ah;
	}
}

public class SortingTest {
	public static void main(String[] args) {
		int test[] = {0, 2, 4, 5, 7, 3, 10, 8, 1, 9 , 6};
		Sorting.heapSort(test);
		
		System.out.println();
		
		for (int i = 0; i < test.length; i++) {
			System.out.print(test[i] + " ");
		}
	}
}
