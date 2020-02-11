package miscellaneous;

public class PalindromeRunner {

    public static void main(String[] args) {
		palindromeCheck();
//        removeCharacterFromString();
    }

    public static void palindromeCheck() {
        String s = "aba";

        int halfLength = s.length() / 2;
        int i;
        for (i = 0; i < halfLength; i++) {
            if (s.charAt(i) != s.charAt(halfLength - i - 1)) {
                System.out.println("Non-Palindrome");
                break;
            }
        }
        if (i == halfLength) {
            System.out.println("Palindrome");
        }
    }

    public static void removeCharacterFromString() {
        String str = "Hello";
        char c = 'l';
        String str2 = str.replaceAll(Character.toString(c), "");
        System.out.println(str2);
    }
}
