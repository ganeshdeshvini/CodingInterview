package adobe;

import java.util.HashMap;
import java.util.Map;

public class GoodBadWordsRegex {
    static String[] goodWords = {"papa", "book", "home", "cars", "jolly", "sugar", "friend", "mother", "father", "bloomiest"};
    static String[] badWords = {"ache", "slow", "torn", "slum", "boom", "rival", "wrong", "cholera", "revenge", "arrogant"};

    public static void main(String[] args) {
        System.out.println(getWordMapping("papa"));
        System.out.println(getWordMapping("ache"));
    }

    static String getWordMapping(String input) {
        Map<String, Integer> map = new HashMap<>();
//        String pattern = "[mjphf].*|[bcs].*[tksr]";
        String pattern = "[mjphf].*|[bcs][tkav].*";
        for (String word : goodWords) {
            map.put(String.valueOf(word.charAt(0)), 1);
            if (input.matches(pattern)) {
                return "good";
            }
        }
        return "bad";
    }
}
