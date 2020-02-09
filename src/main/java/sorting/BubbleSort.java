package sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arrInput = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
//        method1(arrInput);
        optimizedMethod(arrInput);
    }

    private static void optimizedMethod(int[] arrInput) {
        int length = arrInput.length;
        boolean swapped;
        do {
            swapped = false;
            int alreadySorted = 1;
            for (int j = 0; j < length - alreadySorted; j++) {
                if (arrInput[j] > arrInput[j + 1]) {
                    int temp = arrInput[j];
                    arrInput[j] = arrInput[j + 1];
                    arrInput[j + 1] = temp;
                    swapped = true;
                }
            }
            alreadySorted++;
        } while (swapped);
        System.out.println(Arrays.toString(arrInput));
    }

    private static void method1(int[] arrInput) {
        int length = arrInput.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - (i + 1); j++) {
                if (arrInput[j] > arrInput[j + 1]) {
                    int temp = arrInput[j];
                    arrInput[j] = arrInput[j + 1];
                    arrInput[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arrInput));
    }
}
