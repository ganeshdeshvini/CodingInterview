package miscellaneous;

import java.util.HashMap;
import java.util.Map;

public class UniqueStringWithDataStructure {

	public static boolean isUniqueChars2(String str) {
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val])
				return false;
			char_set[val] = true;
		}
		return true;
	}

	public static void removeDuplicates(char[] str) {
		if (str == null)
			return;
		int len = str.length;
		if (len < 2)
			return;
		int tail = 1;
		for (int i = 1; i < len; ++i) {
			int j;
			for (j = 0; j < tail; ++j) {
				if (str[i] == str[j])
					break;
			}
			if (j == tail) {
				str[tail] = str[i];
				++tail;
			}
		}
		str[tail] = 0;
		System.out.println("After");
		System.out.println(str);
	}

	public static boolean isAnagram(String s1, String s2) {
		int s1Len = s1.length();
		int s2Len = s2.length();
		if (s1Len != s2Len) {
			return false;
		}

		int[] letters = new int[256];
		int num_unique_chars = 0;
		int num_completed_t = 0;

		char[] s_array = s1.toCharArray();
		for (char c : s_array) { // count number of each char in s.
			if (letters[c] == 0)
				++num_unique_chars;
			++letters[c];
		}

		for (int i = 0; i < s2.length(); ++i) {
			int c = (int) s2.charAt(i);
			if (letters[c] == 0) { // Found more of char c in t than in s.
				return false;
			}
			--letters[c];
			if (letters[c] == 0) {
				++num_completed_t;
				if (num_completed_t == num_unique_chars) {
					// it�s a match if t has been processed completely
					return i == s2.length() - 1;
				}
			}
		}
		return false;
	}

	public static boolean isAnagramPractice(String a, String b) {
		Map<String, Integer> strHashMap = new HashMap<String, Integer>();
		if (a.length() != b.length()) {
			return false;
		}
		for (int i = 0; i < a.length(); i++) {
			String str = Character.toString(a.charAt(i));
			if (strHashMap.containsKey(str)) {
				int cnt = strHashMap.get(str);
				strHashMap.put(str, ++cnt);
			} else {
				strHashMap.put(str, 1);
			}
		}

		for (int i = 0; i < b.length(); i++) {
			String str = Character.toString(b.charAt(i));
			if (strHashMap.containsKey(str)) {
				int cnt = strHashMap.get(str);
				if (cnt > 1) {
					strHashMap.put(str, --cnt);
				} else {
					// if it is 1 then remove it
					strHashMap.remove(str);
				}

			} else {
				return false;
			}
		}
		return true;
	}

	public static void ReplaceFun(char[] str, int length) {
		int spaceCount = 0, newLength, i = 0;
		for (i = 0; i < length; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		newLength = length + spaceCount * 2;
		str[newLength] = '\0';
		for (i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[newLength - 1] = '0';
				str[newLength - 2] = '2';
				str[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				str[newLength - 1] = str[i];
				newLength = newLength - 1;
			}
		}
		System.out.println(str);
	}

	public static void main(String[] args) {
		String s = "abc";
		// System.out.println(isUniqueChars2(s));
		// removeDuplicates(s.toCharArray());
		// System.out.println(isAnagramPractice("abc", "aac"));
		ReplaceFun(s.toCharArray(), s.length());
	}

}
