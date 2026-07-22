/**
 * Sum of First N Natural Numbers
 * Find the sum of first N natural numbers using recursion.
 *
 * Example:
 * Input: N = 5
 * Output: 15 (1 + 2 + 3 + 4 + 5)
 */
public class SumOfFirstNNumbers {

    /**
     * Recursively calculates sum of first n natural numbers
     * @param n the number
     * @return sum of 1 + 2 + 3 + ... + n
     */
    public static int sumOfNumbers(int n) {
        // Base case: sum of 0 is 0
        if (n <= 0) {
            return 0;
        }

        // Recursive case: n + sum(n-1)
        return n + sumOfNumbers(n - 1);
    }

    public static void main(String[] args) {
        // Test case 1
        int n1 = 5;
        System.out.println("Input: N = " + n1);
        System.out.println("Output: " + sumOfNumbers(n1));
        System.out.println("Expected: 15\n");

        // Test case 2
        int n2 = 10;
        System.out.println("Input: N = " + n2);
        System.out.println("Output: " + sumOfNumbers(n2));
        System.out.println("Expected: 55\n");

        // Test case 3
        int n3 = 1;
        System.out.println("Input: N = " + n3);
        System.out.println("Output: " + sumOfNumbers(n3));
        System.out.println("Expected: 1\n");

        // Test case 4
        int n4 = 0;
        System.out.println("Input: N = " + n4);
        System.out.println("Output: " + sumOfNumbers(n4));
        System.out.println("Expected: 0\n");

        // Test case 5
        int n5 = 100;
        System.out.println("Input: N = " + n5);
        System.out.println("Output: " + sumOfNumbers(n5));
        System.out.println("Expected: 5050");
    }
}