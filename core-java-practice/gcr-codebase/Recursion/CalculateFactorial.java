/**
 * Calculate Factorial
 * Write a recursive function to calculate the factorial of a number.
 *
 * Example:
 * Input: 5
 * Output: 120 (5! = 5 * 4 * 3 * 2 * 1)
 */
public class CalculateFactorial {

    /**
     * Recursively calculates factorial of n
     * @param n the number
     * @return factorial of n
     */
    public static long factorial(int n) {
        // Base case: factorial of 0 or 1 is 1
        if (n <= 1) {
            return 1;
        }

        // Recursive case: n * factorial(n-1)
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        // Test case 1
        int n1 = 5;
        System.out.println("Input: " + n1);
        System.out.println("Output: " + factorial(n1));
        System.out.println("Expected: 120\n");

        // Test case 2
        int n2 = 0;
        System.out.println("Input: " + n2);
        System.out.println("Output: " + factorial(n2));
        System.out.println("Expected: 1\n");

        // Test case 3
        int n3 = 1;
        System.out.println("Input: " + n3);
        System.out.println("Output: " + factorial(n3));
        System.out.println("Expected: 1\n");

        // Test case 4
        int n4 = 6;
        System.out.println("Input: " + n4);
        System.out.println("Output: " + factorial(n4));
        System.out.println("Expected: 720\n");

        // Test case 5
        int n5 = 10;
        System.out.println("Input: " + n5);
        System.out.println("Output: " + factorial(n5));
        System.out.println("Expected: 3628800");
    }
}