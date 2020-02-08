package miscellaneous;

import java.util.HashMap;
import java.util.Map;

public class LongestSubsequenceCharacter {
    public static void main(String[] args) {
        String str = "ABAACDDDBBBBBBBA";
        System.out.println(getLongestSubsequenceCharacter(str));
    }

    private static Map<String, Integer> getLongestSubsequenceCharacter(String str) {
        Map<String, Integer> longestSubChar = new HashMap<>();
        int maxTillNow = 0;
        int maxCurr = 0;
        char maxChar = str.charAt(0);
        char currChar;
        for (int i = 0; i < str.length(); i++) {
            currChar = str.charAt(i);
            char prevChar = i > 0 ? str.charAt(i - 1) : str.charAt(i);
            if (currChar == prevChar) {
                maxCurr++;
                if (maxCurr > maxTillNow) {
                    maxTillNow = maxCurr;
                    maxChar = currChar;
                }
            } else {
                maxCurr = 1;
            }
        }
        longestSubChar.put(String.valueOf(maxChar), maxTillNow);
        return longestSubChar;
    }
}
