package miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

	public static List<String> alternativeFizzBuzz(final int n) {
		final List<String> toReturn = new ArrayList<>(n);
		for (int i = 1; i <= n; i++) {
			final String word = toWord(3, i, "Fizz") + toWord(5, i, "Buzz");
			if (word.isEmpty()) {
				toReturn.add(Integer.toString(i));
			} else {
				toReturn.add(word);
			}
		}
		return toReturn;
	}

	private static String toWord(final int divisor, final int value, final String word) {
		return value % divisor == 0 ? word : "";
	}

	public static List<String> fizzBuzz(final int n) {
		final List<String> toReturn = new ArrayList<>(n);
		for (int i = 1; i <= n; i++) {
			if (i % 15 == 0) {
				toReturn.add("FizzBuzz");
			} else if (i % 3 == 0) {
				toReturn.add("Fizz");
			} else if (i % 5 == 0) {
				toReturn.add("Buzz");
			} else {
				toReturn.add(Integer.toString(i));
			}
		}
		return toReturn;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// List<String> out = fizzBuzz(16);
		List<String> out = alternativeFizzBuzz(16);
		for (String str : out) {
			System.out.println(str);
		}
	}

}
