package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Share
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * Example:
 * <p>
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Note: Please solve it without division and in O(n).
 * <p>
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] arrInput = {1, 2, 3, 4};
//        methodWithDivision(arrInput);
//        methodWithoutDivision(arrInput);
//        optimizedMethod(arrInput);
        optimizedMethodBest(arrInput);
    }

    private static void optimizedMethodBest(int[] arrInput) {
        int length = arrInput.length;
        int[] arrProductRight = new int[length];

        int product = 1;
        arrProductRight[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            product = product * arrInput[i + 1];
            arrProductRight[i] = product;
        }

        System.out.print(arrProductRight[0] + " ");
        product = 1;
        for (int i = 1; i < length; i++) {
            product = product * arrInput[i - 1];
            System.out.print((arrProductRight[i] * product) + " ");
        }
    }

    /**
     * Calculate product from left Pass
     * Calculate product from Right Pass
     * Multiply both the Left * Right Pass for output
     */
    private static void optimizedMethod(int[] arrInput) {

        int length = arrInput.length;
        int[] arrProductLeft = new int[length];
        int[] arrProductRight = new int[length];

        int product = 1;
        arrProductLeft[0] = 1;
        for (int i = 1; i < length; i++) {
            product = product * arrInput[i - 1];
            arrProductLeft[i] = product;
        }

        product = 1;
        arrProductRight[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            product = product * arrInput[i + 1];
            arrProductRight[i] = product;
        }

        for (int i = 0; i < length; i++) {
            System.out.print(arrProductLeft[i] * arrProductRight[i] + " ");
        }
    }

    private static void methodWithDivision(int[] arrInput) {
        int product = 1;
        for (int i = 0; i <= arrInput.length - 1; i++) {
            product = product * arrInput[i];
        }
        for (int i = 0; i <= arrInput.length - 1; i++) {
            System.out.print((product / arrInput[i]) + " ");
        }
    }

    private static void methodWithoutDivision(int[] arrInput) {
        Map<Integer, Integer> indexProductMap = new HashMap<>();
        for (int i = 0; i <= arrInput.length - 1; i++) {
            for (int j = 0; j <= arrInput.length - 1; j++) {
                if (i != j) {
                    addToMap(indexProductMap, arrInput[i], j);
                }
            }
        }
        for (int i = 0; i <= arrInput.length - 1; i++) {
            System.out.print(indexProductMap.get(i) + " ");
        }
    }

    private static void addToMap(Map<Integer, Integer> indexProductMap, int value, int index) {
        Integer product = indexProductMap.get(index);
        if (product == null) {
            indexProductMap.put(index, value);
        } else {
            indexProductMap.put(index, product * value);
        }
    }
}
