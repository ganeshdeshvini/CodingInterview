package miscellaneous;

import java.util.HashMap;
import java.util.Map;

public class FirstRecurringCharacter {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 4, 2, 5, 6, 1};
        System.out.println("First repeating character: " + method1(arr));
    }

    private static Integer method1(int[] arr) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int x : arr) {
            if (seen.containsKey(x)) {
                return x;
            } else {
                seen.put(x, 1);
            }
        }
        return null;
    }
}
