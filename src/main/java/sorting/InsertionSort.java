package sorting;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arrInput = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        method1(arrInput);
    }

    private static void method1(int[] arrInput) {
        int length = arrInput.length;
        List<Integer> sorted = new ArrayList<>();
        sorted.add(arrInput[0]);

        for (int i = 1; i < length; i++) {
            int lengthSortedList = sorted.size();
            if (arrInput[i] < sorted.get(lengthSortedList - 1)) {
                int j = lengthSortedList - 1;
                for (; j >= 0; j--) {
                    if (arrInput[i] > sorted.get(j)) {
                        break;
                    }
                }
                sorted.add(j + 1, arrInput[i]);
            } else {
                sorted.add(arrInput[i]);
            }
        }

        System.out.println(sorted);
    }
}
