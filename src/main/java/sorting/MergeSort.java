package sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arrInput = {3, 44, 38, 5, 47, 3, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
//        int[] arrInput = {3, 44, 38, 5, 47, 15, 36, 26};
//        int[] arrInput = {3, 44, 38, 5};
        mergeSortMethod1(arrInput);
        System.out.println(Arrays.toString(arrInput));
    }

    private static void mergeSortMethod1(int[] arrInput) {
        int length = arrInput.length;
        if (length == 1) {
            return;
        }
        int mid = length / 2;
        int[] left = Arrays.copyOfRange(arrInput, 0, mid);
        int[] right = Arrays.copyOfRange(arrInput, mid, length);
        mergeSortMethod1(left);
        mergeSortMethod1(right);
        merge2SortedArray(arrInput, left, right);
    }

    private static void merge2SortedArray(int[] arrInput, int[] arrLeft, int[] arrRight) {
        int leftLength = arrLeft.length;
        int rightLength = arrRight.length;

        int leftIndex = 0;
        int rightIndex = 0;
        int sortedIndex = 0;
        while (leftIndex < leftLength || rightIndex < rightLength) {
            // If Left array is finished then skip & move to else part
            // If right array is finished OR If Left is less than right
            if (!isLeftArrayCompleted(leftIndex, leftLength) && (isRightArrayCompleted(rightIndex, rightLength) || arrLeft[leftIndex] < arrRight[rightIndex])) {
                arrInput[sortedIndex] = arrLeft[leftIndex];
                leftIndex++;
            } else {
                arrInput[sortedIndex] = arrRight[rightIndex];
                rightIndex++;
            }
            sortedIndex++;
        }
    }

    private static boolean isLeftArrayCompleted(int leftIndex, int leftLength) {
        return isArrayCompleted(leftIndex, leftLength);
    }

    private static boolean isRightArrayCompleted(int rightIndex, int rightLength) {
        return isArrayCompleted(rightIndex, rightLength);
    }

    private static boolean isArrayCompleted(int index, int length) {
        return index >= length;
    }
}
