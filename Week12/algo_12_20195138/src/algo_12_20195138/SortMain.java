package algo_12_20195138;

public class SortMain {
	public static void main(String[] args) {
		//selection
		int[] a = {5, 2, 8, 3, 1};
		System.out.println("정렬전 배열 원소: ");
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		
		Sorting.selectionSort(a);
		System.out.println("정렬된 배열 원소: ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		
		//bubble
		int[] b = {5, 2, 11, 8, 3, 1, 7};
		System.out.println("정렬전 배열 원소: ");
		
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.println();
		
		Sorting.bubbleSort(b);
		System.out.println("정렬된 배열 원소: ");
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.println();
	}
}
