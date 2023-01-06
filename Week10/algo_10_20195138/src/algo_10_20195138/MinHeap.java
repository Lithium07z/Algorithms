package algo_10_20195138;

class MinHeap {
	private int count;
	private int size;
	private CompKey[] itemArray;

	public MinHeap() {
		count = 0;
		size = 64;
		itemArray = new CompKey[size];
	}

	public MinHeap(CompKey[] origArray) {
		count = origArray.length - 1;
		size = count + 1;
		itemArray = origArray;
		int childLoc;
		int currentLoc;
		for (currentLoc = count / 2; currentLoc > 0; currentLoc--) {
			childLoc = currentLoc * 2;
			while (childLoc <= count) {
				if (childLoc < count) {
					if (itemArray[childLoc + 1].compareTo(itemArray[childLoc]) < 0)
						childLoc++;
				}
				if (itemArray[currentLoc].compareTo(itemArray[childLoc]) <= 0)
					break; // ??
				else {
					CompKey temp = itemArray[currentLoc];
					itemArray[currentLoc] = itemArray[childLoc];
					itemArray[childLoc] = temp;
					currentLoc = childLoc;
					childLoc = currentLoc * 2;
				} // else
			} // while
		} // for
	}

	public void insert(CompKey newItem) {
		if (count >= size - 1) {
			System.out.println();
			return;
		}
		count++;
		int childLoc = count;
		int parentLoc = childLoc / 2;
		while (parentLoc != 0) {
			if (newItem.compareTo(itemArray[parentLoc]) >= 0) {
				itemArray[childLoc] = newItem;
				return;
			} else {
				itemArray[childLoc] = itemArray[parentLoc];
				childLoc = parentLoc;
				parentLoc = childLoc / 2;
			}
		}
		itemArray[childLoc] = newItem;
	}

	public CompKey delete() {
		if (count == 0) {
			return null;
		} else {
			int currentLoc;
			int childLoc;
			CompKey itemToMove;
			CompKey deletedItem;
			deletedItem = itemArray[1];
			itemToMove = itemArray[count--];
			currentLoc = 1;
			childLoc = 2 * currentLoc;
			while (childLoc <= count) {
				if (childLoc < count) {
					if (itemArray[childLoc + 1].compareTo(itemArray[childLoc]) < 0)
						childLoc++;
				}
				if (itemArray[childLoc].compareTo(itemToMove) < 0) {
					itemArray[currentLoc] = itemArray[childLoc];
					currentLoc = childLoc;
					childLoc = 2 * currentLoc;
				} else {
					itemArray[currentLoc] = itemToMove;
					return deletedItem;
				}
			} // while
			itemArray[currentLoc] = itemToMove;
			return deletedItem;
		} // else
	}

	public int numberElements() {
		return count;
	}
}
