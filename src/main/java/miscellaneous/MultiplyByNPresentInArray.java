package miscellaneous;

import java.util.HashMap;
import java.util.Map;

public class MultiplyByNPresentInArray {

    public static void main(String[] args) {
        int[] arr = { 2, 4, 1, 5, 6, 40, 10 };
        System.out.println(multiplyBy20InArray(arr, 20));
        System.out.println(multiplyBy20InArray(arr, 30));
    }

    private static String multiplyBy20InArray(int[] arr, int multipleToFind) {
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int num : arr) {
            int divisibleBy = multipleToFind / num;
            if (map.containsKey(divisibleBy)) {
                map.put(divisibleBy, num);
                stringBuilder.append(divisibleBy + " X " + num + " = " + multipleToFind + "\n");
            } else {
                map.put(num, 0);
            }
        }
        return stringBuilder.toString();
    }

}
