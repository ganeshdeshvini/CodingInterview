package sorting;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {

	public static List<Integer> quicksort(List<Integer> numbers) {
		// If array less has 0 or 1 element then it is already sorted hence
		// return that
		if (numbers.size() < 2) {
			return numbers;
		}
		Integer pivot = numbers.get(0);
		List<Integer> lower = new ArrayList<>();
		List<Integer> higher = new ArrayList<>();
		for (int i = 1; i < numbers.size(); i++) {
			if (numbers.get(i) < pivot) {
				lower.add(numbers.get(i));
			} else {
				higher.add(numbers.get(i));
			}
		}
		List<Integer> sortedLower = quicksort(lower);
		sortedLower.add(pivot);
		List<Integer> sortedHigher = quicksort(higher);
		sortedLower.addAll(sortedHigher);
		return sortedLower;
	}

	public static void main(String[] args) {
		// List<Integer> input = Arrays.asList(24, 2, 45, 20, 56, 75, 2, 56, 99,
		// 53, 12);
		List<Integer> input = Arrays.asList(24, 2, 45, 20);
		List<Integer> output = quicksort(input);
		for (int i : output) {
			System.out.print(i);
			System.out.print(" ");
		}
	}
}
