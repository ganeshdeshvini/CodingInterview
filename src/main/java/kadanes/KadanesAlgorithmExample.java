package kadanes;

public class KadanesAlgorithmExample {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int sum = getMaximumSubarrayUsingKadane(arr);
        System.out.println(sum);
    }

    private static int getMaximumSubarrayUsingKadane(int[] arr) {
        int maxCurrent = arr[0];
        int maxSoFar = maxCurrent;

        for (int num : arr) {
            maxCurrent = Integer.max(num, maxCurrent + num);
            maxSoFar = Integer.max(maxSoFar, maxCurrent);
        }
        return maxSoFar;
    }
}
