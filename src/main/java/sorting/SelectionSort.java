package sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arrInput = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
//        int[] arrInput = {3, 44, 38, 5, 47};
        method1(arrInput);
        method2(arrInput);
    }

    private static void method1(int[] arrInput) {
        int length = arrInput.length;
        for (int i = 0; i < length; i++) {
            int smallest = arrInput[i];
            int indexSmallest = i;
            for (int j = i + 1; j < length; j++) {
                if (arrInput[j] < smallest) {
                    smallest = arrInput[j];
                    indexSmallest = j;
                }
            }
            if (indexSmallest != i) {
                int temp = arrInput[i];
                arrInput[i] = arrInput[indexSmallest];
                arrInput[indexSmallest] = temp;
            }
        }
        System.out.println(Arrays.toString(arrInput));
    }

    private static void method2(int[] arrInput) {
        int length = arrInput.length;
        for (int i = 0; i < length; i++) {
            int temp = arrInput[i];
            int indexSmallest = i;
            for (int j = i + 1; j < length; j++) {
                if (arrInput[j] < arrInput[indexSmallest]) {
                    indexSmallest = j;
                }
            }
            if (indexSmallest != i) {
                arrInput[i] = arrInput[indexSmallest];
                arrInput[indexSmallest] = temp;
            }
        }
        System.out.println(Arrays.toString(arrInput));
    }
}
