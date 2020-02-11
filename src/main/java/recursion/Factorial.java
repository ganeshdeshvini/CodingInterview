package recursion;

public class Factorial {

	// 5! = 5*4*3*2*1
	static int factRecursive(int n) {
//		 System.out.println("Calculating fact(" + n + ")");
//		System.out.print(n + " * ");
		if (n <= 1) {
			return 1;
		}
		int val = n * factRecursive(n - 1);
//		 System.out.println("fact(" + n + ") = " + val);
		return val;
	}

	static int factIteration(int n) {
		int fact = n;
		for (int i = n - 1; i > 1; i--) {
			fact = fact * i;
		}
		return fact;
	}

	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(" = " + factRecursive(15));
		long end = System.nanoTime();
		long elapsedSeconds = end - start;
		System.out.println(elapsedSeconds);

		start = System.nanoTime();
		System.out.println(" = " + factIteration(15));
		end = System.nanoTime();
		elapsedSeconds = end - start;
		System.out.println(elapsedSeconds);
	}
}