package miscellaneous;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    Map<Integer, Integer> calculatedFiboValues = new HashMap<>();

    void fibonnacciRecursiveAllValues(int n) {
        System.out.print("0, 1, 1");
        fiboAllValues(n - 2);
    }

    int fiboAllValues(int n) {
        if (n <= 1) {
            return 1;
        }
        int num = fiboAllValues(n - 1) + fiboAllValues(n - 2);
        System.out.print(", " + num);
        return num;
    }

    int fibonnaciRecursiveOnlySingleValue(int n) {
        if (n <= 1) {
            return n;
        }
        Integer val = calculatedFiboValues.get(n);
        if (val != null) {
            return val;
        }
        int newValue = fibonnaciRecursiveOnlySingleValue(n - 1) + fibonnaciRecursiveOnlySingleValue(n - 2);
        calculatedFiboValues.put(n, newValue);
        return newValue;
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int n = 5;
        System.out.println(fibonacci.fibonnaciRecursiveOnlySingleValue(n - 1));
    }
}
