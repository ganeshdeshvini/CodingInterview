package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given an array of strings, group anagrams together.
 * <p>
 * Example:
 * <p>
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 */
public class Anagrams {
    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "silent";

//        System.out.println(method1(s1, s2));
        System.out.println(isAnagram(s1, s2));
        String[] arrInput = {"are", "bat", "ear", "code", "tab", "era"};
        System.out.println(groupAnagrams(arrInput));
    }

    private static List<List<String>> groupAnagrams(String[] arrInput) {
        Map<String, Set<Integer>> mapAnagramGroups = new HashMap<>();
        Map<Integer, Integer> skipIndex = new HashMap<>();
        int length = arrInput.length;
        for (int i = 0; i <= length - 1; i++) {
            if (skipIndex.containsKey(i)) {
                continue;
            }
            String lhs = arrInput[i];
            for (int j = i + 1; j <= length  - 1; j++) {
                if(skipIndex.containsKey(j)) {
                    continue;
                }
                String rhs = arrInput[j];
                if (isAnagram(lhs, rhs)) {
                    if (mapAnagramGroups.containsKey(lhs)) {
                        Set<Integer> seenAnagramIndexSet = mapAnagramGroups.get(lhs);
                        seenAnagramIndexSet.add(i);
                        seenAnagramIndexSet.add(j);
                    } else {
                        Set<Integer> seenAnagramIndexSet = new HashSet<>();
                        seenAnagramIndexSet.add(i);
                        seenAnagramIndexSet.add(j);
                        mapAnagramGroups.put(lhs, seenAnagramIndexSet);
                        skipIndex.put(j, 1);
                    }
                }
            }
        }

        List<List<String>> result = new ArrayList<>();
        mapAnagramGroups.forEach((key, seenAnagramIndexSet) -> {
            result.add(seenAnagramIndexSet.stream().map(index -> arrInput[index]).collect(Collectors.toList()));
        });
        return result;
    }

    public List<List<String>> groupAnagramsLeetCodeSolution(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    private static boolean isAnagram(String s1, String s2) {
        Map<Character, Integer> seen = new HashMap<>();
        int s1Length = s1.length();
        int s2Length = s2.length();

        if (s1Length != s2Length) {
            return false;
        }

        for (int i = 0; i < s1Length; i++) {
            seen.put(s1.charAt(i), 1);
        }

        Character c = null;
        for (int i = 0; i < s2Length; i++) {
            c = s2.charAt(i);
            if (!seen.containsKey(c)) {
                return false;
            }
            seen.remove(c);
        }
        return seen.isEmpty();
    }

    private static boolean method1(String s1, String s2) {
        int s1Length = s1.length();
        int s2Length = s2.length();

        for (int i = 0; i < s1Length; i++) {

        }
        return false;
    }
}
