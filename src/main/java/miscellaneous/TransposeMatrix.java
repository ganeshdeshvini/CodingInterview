package miscellaneous;

import helpers.Util;

public class TransposeMatrix {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int rowLength = arr.length;
		int colLength = arr[0].length;
		int[][] transporseArr = new int[colLength][rowLength];

		for (int i = 0; i < rowLength; i++) {
			for (int j = 0; j < colLength; j++) {
				transporseArr[i][j] = arr[j][i];
			}
		}
		Util.displayArray(arr, "|");
		System.out.println();
		Util.displayArray(transporseArr, "|");
	}

}
