package searching;

import java.util.Arrays;
import java.util.List;

public class BinarySearchExample {
    public static boolean binarySearchRecursion(final List<Integer> numbers, final Integer value) {
        if (numbers == null || numbers.isEmpty()) {
            return false;
        }
        final Integer mid = numbers.get(numbers.size() / 2);
        if (value.equals(mid)) {
            return true;
        }
        if (value < mid) {
            return binarySearchRecursion(numbers.subList(0, numbers.size() / 2), value);
        } else {
            return binarySearchRecursion(numbers.subList(numbers.size() / 2 + 1, numbers.size()), value);
        }
    }

    public static int binarySearchIterative(List<Integer> numbers, int key) {
        int startIndex = 0;
        int endIndex = numbers.size() - 1;

        while (startIndex < endIndex) {
            int midIndex = (endIndex - startIndex / 2) + startIndex;
            int midValue = numbers.get(midIndex);

            if (key > midValue) {
                startIndex = midIndex++;
            } else if (key < midValue) {
                endIndex = midIndex - 1;
            } else {
                return midIndex;
            }
        }

        return -1;
    }

    public static int binarySearchIterativeOptimized(List<Integer> numbers, int key) {
        int low = 0;
        int high = numbers.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            Integer midVal = numbers.get(mid);
            int compareResult = midVal.compareTo(key);

            if (compareResult < 0) {
                low = mid + 1;
            } else if (compareResult > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        List<Integer> sortedList = Arrays.asList(11, 21, 31, 41, 51);
        // boolean isFound = binarySearchRecursion(sortedList, 3);
        // System.out.println(isFound ? "Found" : "Not Found");
        // System.out.println(binarySearchIterative(sortedList, 3));
//        System.out.println(binarySearchIterativeOptimized(sortedList, 2));
        System.out.println(tryBinarySearch(sortedList, 21));
    }

    static boolean tryBinarySearch(List<Integer> sortedList, int itemToFind) {
        int startIndex = 0;
        int endIndex = sortedList.size() - 1;
        int mid = 0;
        while (startIndex <= endIndex) {
            mid = (startIndex + endIndex) / 2;
            int midValue = sortedList.get(mid);
            if (itemToFind == midValue) {
                System.out.println("match found");
                return true;
            } else if (midValue > itemToFind) {
                endIndex = mid - 1;
            } else {
                startIndex = mid + 1;
            }
        }
        return false;
    }
}
