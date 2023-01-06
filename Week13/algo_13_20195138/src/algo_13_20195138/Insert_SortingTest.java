package algo_13_20195138;

public class Insert_SortingTest {
	public static void main(String[] args) {
		int test[] = {6, 1, 7, 8, 5, 3, 2}; 
				
		Insert_Sorting.insertionSort(test);
		
		for (int i = 0; i < 7; i++) {
			System.out.print(test[i] + " ");
		}
	}
}

class Insert_Sorting {
	public static void insertionSort(int[] a) {
		int temp;
		boolean flag;
		for (int i = 1; i < a.length; i++) {
			temp = a[i];
			int j = i;
			if (a[j - 1] > temp) {
				flag = true;
			} else {
				flag = false;
			}
			while (flag) {
				a[j] = a[j - 1];
				j--;
				if (j > 0 && a[j - 1] > temp) {
					flag = true;
				} else {
					flag = false;
				}
			}
			a[j] = temp;
		}
	}
}
