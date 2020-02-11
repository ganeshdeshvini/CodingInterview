package miscellaneous;


public class Recursion {
    public static void main(String args[]) {
        // Factorial f = new Factorial();
        // System.out.println("Factorial of 3 is " + f.fact(3));
        // System.out.println("Factorial of 4 is " + f.fact(4));
        // System.out.println("Factorial of 5 is " + f.fact(5));
        // ===========================================
        int n = 10;
        RecTest obj = new RecTest(n);
        for (int i = 0; i < n; i++) {
            obj.values[i] = i;
        }

        // // printing via normal for loop
        // for (int i = 0; i < n; i++) {
        // System.out.println(obj.values[i]);
        // }

        // printing via recursion
        obj.printArray(n);
    }

    //A simple example of recursion.
    static class Factorial {
        // this is a recursive method
        int fact(int n) {
            System.out.println("Value for n " + n);
            int result;
            if (n == 1) {
                System.out.println("Return 1");
                return 1;
            }

            result = fact(n - 1) * n;
            System.out.println("Result" + result);
            return result;
        }
    }

    static class RecTest {
        int values[];

        RecTest(int i) {
            values = new int[i];
        }

        void printArray(int i) {
            System.out.println("i=" + i);
            if (i == 0) {
                return;
            } else {
                printArray(i - 1);
            }
            System.out.println(values[i - 1]);
        }
    }
}