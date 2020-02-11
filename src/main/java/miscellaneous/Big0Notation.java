package miscellaneous;

/*
 * The Class BigOExamples.
 */
public class Big0Notation {

	/**
	 * Constant. O(1)
	 */
	public int constant(int n) {

		if (n > 1) {
			return n;
		} else {
			return 0;
		}
	}

	/**
	 * Linear. O(n)
	 */
	public int linear(int n) {
		int sum = 0;
		for (int j = 0; j < n; j++) {
			sum += j;
		}
		return sum;
	}

	/**
	 * Quadratic. O(n^2)
	 */
	public int quadratic(int n) {
		int sum = 0;
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < n; k++) {
				sum += j * k;
			}
		}
		return sum;
	}

	/**
	 * Cubic. O(n^3)
	 */
	public int cubic(int n) {
		int sum = 0;
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < n; k++) {
				for (int l = 0; l < n; l++) {
					sum += j * k / (l + 1);
				}
			}
		}
		return sum;
	}

	/**
	 * Logarithmic. O(log n). Binary Search.
	 */
	public int logarithmic(Integer[] data, int key) {
		int startIndex = 0;
		int endIndex = data.length - 1;

		while (startIndex < endIndex) {
			int midIndex = (endIndex - startIndex / 2) + startIndex;
			int midValue = data[midIndex];

			if (key > midValue) {
				startIndex = midIndex++;
			} else if (key < midValue) {
				endIndex = midIndex - 1;
			} else {
				return midIndex;
			}
		}
		return -1;
	}

	/**
	 * Linear Logarithmic. O(n log n). Quick Sort.
	 * 
	 * @param data
	 *            the to search
	 * @param key
	 *            the key
	 * @return the int
	 */
	public Integer linearLogarithmic(Integer[] data) {

		QuickSort<Integer> sorter = new QuickSort<Integer>();
		sorter.sort(data);

		return data[0];
	}

}

/*
 * The Class QuickSort.
 * 
 * @param <t> the generic type
 */
class QuickSort<T extends Comparable<T>> {

	/**
	 * Sort.
	 * 
	 * @param array
	 *            the array
	 */
	public void sort(T[] array) {
		array = quicksort(array, 0, array.length - 1);
	}

	/**
	 * Quicksort.
	 * 
	 * @param array
	 *            the array
	 * @param lo
	 *            the lo
	 * @param hi
	 *            the hi
	 * @return the t[]
	 */
	private T[] quicksort(T[] array, int lo, int hi) {
		if (hi > lo) {
			int partitionPivotIndex = (int) (Math.random() * (hi - lo) + lo);
			int newPivotIndex = partition(array, lo, hi, partitionPivotIndex);
			quicksort(array, lo, newPivotIndex - 1);
			quicksort(array, newPivotIndex + 1, hi);
		}
		return (T[]) array;
	}

	/**
	 * Partition.
	 * 
	 * @param array
	 *            the array
	 * @param lo
	 *            the lo
	 * @param hi
	 *            the hi
	 * @param pivotIndex
	 *            the pivot index
	 * @return the int
	 */
	private int partition(T[] array, int lo, int hi, int pivotIndex) {
		T pivotValue = array[pivotIndex];
		swap(array, pivotIndex, hi); // send to the back
		int index = lo;
		for (int i = lo; i < hi; i++) {
			if ((array[i]).compareTo(pivotValue) <= 0) {
				swap(array, i, index);
				index++;
			}
		}
		swap(array, hi, index);
		return index;
	}

	/**
	 * Swap.
	 * 
	 * @param array
	 *            the array
	 * @param i
	 *            the i
	 * @param j
	 *            the j
	 */
	private void swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
