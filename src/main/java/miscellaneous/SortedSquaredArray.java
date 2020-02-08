package miscellaneous;

import java.util.Arrays;

/**
 * Input:-  {-3, -2, 1, 2, 4};
 * Squared:-{9, 4, 1, 4, 16}
 * Output:- {1, 4, 4, 9, 16}
 */
public class SortedSquaredArray {
    public static void main(String[] args) {
        int[] arrInput = {-3, -2, 1, 2, 4};
        System.out.println(Arrays.toString(method1(arrInput)));
        int[] arrInput2 = {-3, -2, 1, 2, 4};
        System.out.println(Arrays.toString(optimizedMethodLinearRuntime(arrInput2)));
    }

    private static int[] optimizedMethodLinearRuntime(int[] arrInput) {
        int length = arrInput.length;
        int left = 0;
        int right = length - 1;
        int[] arrOutput = new int[length];
        for (int i = right; i >= 0; i--) {
            if (Math.abs(arrInput[left]) > Math.abs(arrInput[right])) {
                arrOutput[i] = arrInput[left] * arrInput[left];
                left++;
            } else {
                arrOutput[i] = arrInput[right] * arrInput[right];
                right--;
            }
        }
        return arrOutput;
    }

    private static int[] method1(int[] arrInput) {
        boolean isAllPositive = true;
        boolean isAllNegative = true;
        int positiveStartIndex = 0;
        int length = arrInput.length;

        for (int i = 0; i < length; i++) {
            if (arrInput[i] < 0) {
                isAllPositive = false;
            } else {
                if (positiveStartIndex == 0) {
                    positiveStartIndex = i;
                }
                isAllNegative = false;
            }
            arrInput[i] = arrInput[i] * arrInput[i];
        }

        if (isAllPositive || isAllNegative) {
            return arrInput;
        } else {
            int[] arrOutputTemp = new int[length];
            int positiveIndex = positiveStartIndex;
            int negativeIndex = positiveIndex - 1;
            int cnt = 0;
            while (positiveIndex < length || negativeIndex >= 0) {
                if (negativeIndex < 0 || arrInput[positiveIndex] < arrInput[negativeIndex]) {
                    arrOutputTemp[cnt] = arrInput[positiveIndex];
                    cnt++;
                    positiveIndex++;
                } else {
                    arrOutputTemp[cnt] = arrInput[negativeIndex];
                    cnt++;
                    negativeIndex--;
                }
            }
            return arrOutputTemp;
        }
    }
}
