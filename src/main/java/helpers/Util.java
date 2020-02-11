package helpers;

public class Util {
	public static void displayArray(int[] arr, String delimeter, boolean isNewLine) {
		for (int n : arr) {
			if (!isNewLine) {
				System.out.print(n + delimeter);
			} else {
				System.out.println(n + delimeter);
			}
		}
	}

	public static void displayArray(int[] arr, String delimeter) {
		displayArray(arr, delimeter, true);
	}

	public static void displayArray(int[] arr) {
		displayArray(arr, "", true);
	}

	public static void displayArray(int[] arr, boolean isNewLine) {
		displayArray(arr, "", isNewLine);
	}
	//

	public static void displayArray(int[][] arr, String delimeter, boolean isNewLine) {
		for (int[] subArr : arr) {
			for (int n : subArr) {
				System.out.print(n + delimeter);
			}
			if (isNewLine) {
				System.out.println();
			}
		}
	}

	public static void displayArray(int[][] arr, String delimeter) {
		displayArray(arr, delimeter, true);
	}

	public static void displayArray(int[][] arr) {
		displayArray(arr, "", true);
	}

	public static void displayArray(int[][] arr, boolean isNewLine) {
		displayArray(arr, "", isNewLine);
	}
}
