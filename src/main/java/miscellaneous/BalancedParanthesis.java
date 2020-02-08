package miscellaneous;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedParanthesis {
    public static char[][] TOKENS = {{'{', '}'}, {'[', ']'}, {'(', ')'}};

    public static void main(String[] args) {
        String expression = "{[()]}";
        System.out.println(isBalancedExpressionMethod1(expression));
    }

    private static void createParanthesisMap(char[][] tokens, Map<Character, Character> paranthesisMap) {
        for (char[] token : tokens) {
            paranthesisMap.put(token[0], token[1]);
        }
    }

    private static boolean isBalancedExpressionMethod1(String expression) {
        Map<Character, Character> paranthesisMap = new HashMap<>();
        createParanthesisMap(TOKENS, paranthesisMap);
        Stack<Character> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            if (paranthesisMap.containsKey(c)) {
                //if it is OPENING Parenthesis
                stack.push(c);
            } else {
                // if it is CLOSING Parenthesis
                if (stack.isEmpty()) {
                    return false;
                }
                Character character = paranthesisMap.get(stack.pop());
                if (!character.equals(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
