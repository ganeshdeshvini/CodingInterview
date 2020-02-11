package miscellaneous;

import java.util.HashMap;
import java.util.Map;

public class MissingNumber {

    static void findMissingNumber(int[] x) {
        int missingIndex = 0;
        int sumAllNumbers = 0;
        int sumOfNumbersPresent = 0;
        for (int i = 0; i < x.length; i++) {
            sumAllNumbers += i + 1;
            sumOfNumbersPresent += x[i];
            if (x[i] == 0) {
                missingIndex = i;
            }
        }
        int missingNumber = sumAllNumbers - sumOfNumbersPresent;
        System.out.println(
                "missing number: " + missingNumber + ", missingIndex: " + missingIndex + ", sum= " + sumAllNumbers);
        // alternate way to calculate sum of numbers
        System.out.println("Sum of numbers alternate way: " + ((x.length * (x.length + 1)) / 2.0));// (n*(n+1))/2.0
    }

    static void findMissingNumberOptimized(int[] arr) {
        int length = arr.length;
        int newArr[] = new int[length];
        int i;
        for (i = 0; i < length; i++) {
            newArr[i] = i + 1;
        }
        for (i = 0; i < arr.length; i++) {
            if (arr[i] == newArr[i]) {
                continue;
            }

            if (i == length - 1) {
                break;
            }
            if (arr[i] == newArr[i + 1]) {
                break;
            }
        }
        if (i == length) {
            System.out.println("No missing item found");
        } else {
            System.out.printf("Found missing item: %d", arr[i] - 1);
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 4, 5};

//        findMissingNumber(x);
        findMissingNumberOptimized(arr);
    }

}
