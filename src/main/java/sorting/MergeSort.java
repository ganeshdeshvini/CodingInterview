package sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arrInput = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        long startTime = System.nanoTime();
        method1(arrInput);
        long endTime = System.nanoTime();
        System.out.println("Merge Sort runtime: " + (endTime - startTime));
//        method2(arrInput);
    }

    private static void method1(int[] arrInput) {
        int[] arrOutput = new int[arrInput.length];
        mergeSort(arrInput, arrOutput);
    }

    private static void mergeSort(int[] arrInput, int[] arrOutput) {
        System.out.println(Arrays.toString(arrInput));
        int n = arrInput.length;
        if (n == 1) {
            System.out.println("Exitted");
            return;
        }
        int mid = n / 2;
        int[] left = Arrays.copyOfRange(arrInput, 0, mid);
        int[] right = Arrays.copyOfRange(arrInput, mid, n);
        mergeSort(left, arrOutput);
        mergeSort(right, arrOutput);
        merge(arrOutput, left, right);
    }

    private static void merge(int[] arrOutput, int[] left, int[] right) {

    }
}
