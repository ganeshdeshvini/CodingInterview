package miscellaneous;

import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {0, 3, 4, 31};
        int[] arr2 = {4, 6, 30};

        merge2sortedArrays(arr1, arr2);
    }

    private static void merge2sortedArrays(int[] arrFirst, int[] arrSecond) {
        int index = 0;
        int arrFirstLength = arrFirst.length;
        int arrSecondLength = arrSecond.length;
        int[] arrMerged = new int[arrFirstLength + arrSecondLength];

        int arrFirstIndex = 0;
        int arrSecondIndex = 0;
        while (arrFirstIndex <= arrFirstLength - 1 || arrSecondIndex <= arrSecondLength - 1) {
            if (isSecondArrayFinished(arrSecondLength, arrSecondIndex) || arrFirst[arrFirstIndex] <= arrSecond[arrSecondIndex]) {
                arrMerged[index++] = arrFirst[arrFirstIndex];
                arrFirstIndex++;
            } else {
                arrMerged[index++] = arrSecond[arrSecondIndex];
                arrSecondIndex++;
            }
        }
        System.out.println(Arrays.toString(arrMerged));
    }

    private static boolean isSecondArrayFinished(int arrSecondLength, int arrSecondIndex) {
        return arrSecondIndex >= arrSecondLength;
    }
}
