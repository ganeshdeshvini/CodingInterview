package miscellaneous;

import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] arrLeft = {0, 3, 4, 31};
        int[] arrRight = {4, 6, 30};
        merge2sortedArrays(arrLeft, arrRight);
    }

    private static void merge2sortedArrays(int[] arrLeft, int[] arrRight) {
        int leftLength = arrLeft.length;
        int rightLength = arrRight.length;
        int[] arrSorted = new int[leftLength + rightLength];

        int sortedIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < leftLength || rightIndex < rightLength) {
            // If Left array is finished then skip & move to else part
            // If right array is finished OR If Left is less than right
            if (!isLeftArrayCompleted(leftIndex, leftLength) && (isRightArrayCompleted(rightIndex, rightLength) || arrLeft[leftIndex] < arrRight[rightIndex])) {
                arrSorted[sortedIndex++] = arrLeft[leftIndex];
                leftIndex++;
            } else {
                arrSorted[sortedIndex++] = arrRight[rightIndex];
                rightIndex++;
            }
        }
        System.out.println(Arrays.toString(arrSorted));
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
