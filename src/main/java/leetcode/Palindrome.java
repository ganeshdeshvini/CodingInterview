package leetcode;

public class Palindrome {
    public static void main(String[] args) {
        String s = "MADAMS";
//        String s = "123321";
//        System.out.println(method1(s));
        System.out.println(method2(s));
    }

    private static boolean method1(String s) {
        int end = s.length() - 1;
        String s2 = "";
        for (int i = s.length() - 1, cnt=1; i >= 0; i--, cnt++) {
            System.out.println(cnt + ".");
            s2 += s.charAt(i);
        }
        return s.equals(s2);
    }

    private static boolean method2(String s) {
        int end = s.length() - 1;
        for (int start = 0; start <= end; start++, end--) {
            System.out.print(start + 1  + ".");
            if(start >= end) {
                return true;
            }
            if(s.charAt(start) != s.charAt(end)) {
                System.out.println("didn't do checking for index: " + start);
                return false;
            }
        }
        return false;
    }
}
