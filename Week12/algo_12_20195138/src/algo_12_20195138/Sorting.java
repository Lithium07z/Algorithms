package algo_12_20195138;

public class Sorting {
	public static void selectionSort(int[] a) {
		int i, j, min = 0;
		for (i = 0; i < a.length - 1; i++) {
			for (j = i + 1, min = i; j < a.length; j++) {
				if (a[j] < a[min]) {
					min = j;
				}
			}
			swap(a, min, i);
		}
	}
	
	public static void swap(int[] a, int j, int k) {
		int temp = a[j];
		a[j] = a[k];
		a[k] = temp;
	}
	
	public static void bubbleSort(int[] a) {
		for (int i = a.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j + 1]) {
					swap(a, j , j + 1);
				}
			}
		}
	}
}
