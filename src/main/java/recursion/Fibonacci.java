package recursion;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
	static Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

	static void fiboIterative(int n) {
		int firstNum = 0;
		int secondNum = 1;
		System.out.print(firstNum + " " + secondNum);
		for (int i = 0; i < n - 2; i++) {
			int fib = firstNum + secondNum;
			firstNum = secondNum;
			secondNum = fib;
			System.out.print(" " + fib);
		}
	}

	static int fibRecursive(int n) {
		if (n <= 1) {
			return n;
		}
		int fib = fibRecursive(n - 1) + fibRecursive(n - 2);
		return fib;
	}

	static int fibRecursiveDynamic(int n) {
		Integer num = memo.get(n);
		if (num != null) {
			return num;
		}
		memo.put(n, fibRecursive(n - 1) + fibRecursive(n - 2));
		return memo.get(n);
	}

	static int fibRecursiveDynamicOptimized(int n) {
		if (n <= 1) {
			return n;
		}
		Integer num = memo.get(n);
		if (num != null) {
			return num;
		}
		memo.put(n, fibRecursive(n - 1) + fibRecursive(n - 2));
		return memo.get(n);
	}

	public static void main(String[] args) {
		// fiboIterative(7);
		System.out.println();
		long start;
		start = System.nanoTime();
		System.out.println(fibRecursive(25));
		System.out.println("Elapsed time = " + (System.nanoTime() - start));
		//
		start = System.nanoTime();
		memo.put(0, 0);
		memo.put(1, 1);
		System.out.println(fibRecursiveDynamic(25));
		System.out.println("Elapsed time = " + (System.nanoTime() - start));
		//
		memo.clear();
		start = System.nanoTime();
		System.out.println(fibRecursiveDynamicOptimized(5));
		System.out.println("Elapsed time = " + (System.nanoTime() - start));
	}
}
