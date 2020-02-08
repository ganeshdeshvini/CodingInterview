package Big0Notation;

public class Big0NotationExample {
    public static void main(String[] args) {
        bigOof1Example();
        bigOofNExample();
        bigOofNSquareExample();
        bigOofLogNExample();
    }

    static void bigOof1Example() {
        int[] arr = {1, 2, 3};

        System.out.println(arr[2]);
    }

    static void bigOofNExample() {
        int[] arr = {1, 2, 3};

        int noToFind = 3;
        int iterationCount = 0;
        for (int i = 0; i < arr.length; i++) {
            iterationCount++;
            if (arr[i] == noToFind) {
                System.out.println("Found no: " + noToFind);
                break;
            }
        }
        System.out.println("Worst case total iteration:- " + iterationCount);
    }

    static void bigOofNSquareExample() {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int iterationCount = 0;
        int noToFind = 6;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                iterationCount++;
                if (arr[i][j] == noToFind) {
                    System.out.println("Found no: " + noToFind);
                    break;
                }
            }
        }
        System.out.println("Worst case total iteration:- " + iterationCount);
    }

    // log n to the base 2 i.e., log2n (2 is the base), find in calculator
    // log2n => Divide by 2, & go on dividing by 2 until you are close to zero
    // eg:- 100 numbers == 7 steps
    // 1st step 100/2 = 50
    // 2nd step 50/2 = 25
    // 3rd step 25/2 = 12
    // 4th step 12/2 = 6
    // 5th step 6/2 = 3
    // 6th step 3/2 = 1
    // 7th step 1/2 = 0.5
    // so log n => log 100 => 7
    static void bigOofLogNExample() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int noToFind = 2;
        int found = findUsingBinarySearch(arr, noToFind);
        if (found >= 0) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }

    }

    static int findUsingBinarySearch(int[] arr, int noToFind) {
        System.out.println("Binary Search");
        int iterationCount = 0;

        int startIndex = 0;
        int endIndex = arr.length - 1;
        int mid;

        while (startIndex < endIndex) {
            iterationCount++;
            mid = (startIndex + endIndex) / 2;

            if (arr[mid] == noToFind) {
                System.out.println("Iteration count: " + iterationCount);
                return mid;
            }

            if (mid > noToFind) {
                endIndex = mid - 1;
            } else {
                startIndex = mid + 1;
            }
        }
        System.out.println("Iteration count: " + iterationCount);
        return Integer.MIN_VALUE;
    }
}
