package miscellaneous;

import helpers.Util;

/**
 * input 1, 2, 3, 4, 5
 * 
 * output 4, 5, 1, 2, 3(shifting by 2)
 * 
 * @author ganesh deshvini
 *
 */
public class ArrayCircularShifting {
	public static void main(String[] args) {
		int[] arrInput = { 1, 2, 3, 4, 5 };
		int len = arrInput.length;
		int[] arrOutput = new int[len];
		int shiftBySize = 2;
		int j = 0;

		for (int i = len - 1; i > len - shiftBySize - 1;) {
			arrOutput[j++] = arrInput[i--];
		}
		for (int i = 0; i < len - shiftBySize;) {
			arrOutput[j++] = arrInput[i++];
		}
		Util.displayArray(arrOutput, ",", false);
	}
}