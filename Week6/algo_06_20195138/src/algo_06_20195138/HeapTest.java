package algo_06_20195138;

class Heap {
	private int count;
	private int size;
	private int[] itemArray;

	public Heap() {
		count = 0;
		size = 64;
		itemArray = new int[size];
	}

	public Heap(int[] origArray) {
		this.count = origArray.length - 1;
		this.itemArray = origArray;

		for (int i = count / 2; i >= 1; i -= 1) {
			int p = i;
			int j;
			for (j = i * 2; j <= count; j *= 2) {
				if (j < count && itemArray[j] < itemArray[j + 1]) {
					j += 1;
				}
				if (itemArray[p] >= itemArray[j]) {
					break;
				} else {
					int temp = itemArray[p];
					itemArray[p] = itemArray[j];
					itemArray[j] = temp;
				}
				p = j;
			}
		}
	}

	public void insert(int newItem) {
		count += 1;
		int i = count;
		while (true) {
			if (i == 1) {
				itemArray[1] = newItem;
				break;
			}
			if (newItem <= itemArray[i / 2]) {
				itemArray[i] = newItem;
				break;
			} else {
				itemArray[i] = itemArray[i / 2];
			}
			i /= 2;
		}
		itemArray[i] = newItem;
	}

	public int delete() {
		if (count == 0) {
			return -1;
		}
		int item = itemArray[1];
		int temp = itemArray[count];
		count -= 1;

		int i = 1;
		int j = 2;

		while (j <= count) {
			if (j < count && itemArray[j] < itemArray[j + 1]) {
				j += 1;
			}
			if (temp >= itemArray[j]) {
				break;
			}
			itemArray[i] = itemArray[j];
			i = j;
			j *= 2;
		}
		itemArray[i] = temp;
		return item;
	}

	public void printHeap() {
		int i;
		for (i = 1; i <= count; i++)
			System.out.print(itemArray[i] + " ");
		System.out.println();
	}
}

class HeapTest {
	public static void main(String args[]) {
		Heap h = new Heap();
		h.insert(30);
		h.insert(40);
		h.insert(20);
		h.insert(10);
		h.insert(35);
		h.insert(45);
		h.insert(50);
		h.insert(25);
		h.insert(70);
		h.insert(48);
		h.insert(64);
		h.printHeap();
		System.out.println(h.delete());
		System.out.println(h.delete());
		System.out.println(h.delete());
		System.out.println(h.delete());
		System.out.println(h.delete());
		System.out.println(h.delete());
		System.out.println(h.delete());
		System.out.println(h.delete());
		System.out.println(h.delete());
		System.out.println(h.delete());
		System.out.println(h.delete());

		System.out.println("************************");

		// -10은 의미없는 숫자임
		int[] origArray = { -10, 50, 55, 60, 30, 70, 90, 25, 80, 40, 45 };
		h = new Heap(origArray);
		h.printHeap();

		/*
		 * // -10은 의미없는 숫자임 int[] origArray1 = {-10, 50, 55, 60, 30, 70, 90, 25, 80, 40,
		 * 45}; Heap h1 = Heap.makeHeap(origArray1); h.printHeap();
		 */
		System.out.println(h.delete());
		System.out.println(h.delete());

		h.printHeap();

	}
}