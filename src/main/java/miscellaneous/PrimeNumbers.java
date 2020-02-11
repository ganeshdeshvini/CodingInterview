package miscellaneous;

public class PrimeNumbers {
	static PrimeNumbers num;

	public static boolean sqrtMethod(int n) {

		int sqrt = ((int) Math.sqrt(n) + 1);
		System.out.println(sqrt);
		int cnt = 1;
		for (int i = 2, j = 1; i < sqrt; i++, cnt++) {
			if (n % i == 0) {
				System.out.println("Number of iterations " + cnt);
				return false;
			}
		}
		System.out.println("Number of iterations " + cnt);
		return true;
	}

	public static boolean divideBy2Method(int n) {
		int divideby2 = n / 2;
		int cnt = 1;
		for (int i = 2; i < divideby2; i++, cnt++) {
			if (n % i == 0) {
				System.out.println("Number of iterations " + cnt);
				return false;
			}
		}
		System.out.println("Number of iterations " + cnt);
		return true;
	}

	public static boolean customMethod(int n) {
		int sqrt = ((int) Math.sqrt(n)) + 1;
//		System.out.println(sqrt);
		int cnt = 1;
		if (n % 2 == 0) {
			System.out.println("Number of iterations " + cnt);
			return false;
		}

		for (int i = 3; i < sqrt; i = i + 2, cnt++) {
			if (n % i == 0) {
				System.out.println("Number of iterations " + cnt);
				return false;
			}
		}
		System.out.println("Number of iterations " + cnt);
		return true;
	}

	public static boolean javacompleteReferenceExample(int num) {
		int cnt = 1;
		for (int i = 2; i <= num / i; i++, cnt++) {
//			System.out.println(num/i);
			if (num % i == 0) {
				System.out.println("Number of iterations " + cnt);
				return false;

			}
		}
		System.out.println("Number of iterations " + cnt);
		return true;
	}

	public static void main(String[] args) {
		int n = 17;
		boolean isPrime;
		 isPrime = customMethod(n);
		// isPrime = sqrtMethod(n);
		// isPrime = divideBy2Method(n);
		isPrime = javacompleteReferenceExample(n);
		if (isPrime) {
			System.out.println("Number " + n + " is a prime number");
		} else {
			System.out.println("Number " + n + " is not a prime number");
		}

	}
}
