package miscellaneous;

import java.util.HashMap;
import java.util.Map;

public class DuplicateElementInArray {
    static void method1UsingHashMap(int arr[]) {
        Map<Integer, Boolean> alreadyPresent = new HashMap<>();

        alreadyPresent.put(arr[0], true);
        for (int i = 1; i < arr.length; i++) {
            if (alreadyPresent.containsKey(arr[i])) {
                System.out.printf("Duplicate present: %d", arr[i]);
                return;
            }
            alreadyPresent.put(arr[i], true);
        }
        System.out.println("Duplicate not present");
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 5, 3};
        method1UsingHashMap(arr);
    }
}
