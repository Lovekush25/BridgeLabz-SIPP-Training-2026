/**
 * Find nth Fibonacci Number
 * Return the nth Fibonacci number using recursion.
 *
 * Example:
 * Input: 6
 * Output: 8 (Fibonacci sequence: 1, 1, 2, 3, 5, 8...)
 */
public class FibonacciNumber {

    /**
     * Recursively calculates nth Fibonacci number (basic approach)
     * @param n the position in Fibonacci sequence
     * @return nth Fibonacci number
     */
    public static long fibonacci(int n) {
        // Base cases
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        // Recursive case: fib(n) = fib(n-1) + fib(n-2)
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * Optimized Fibonacci using memoization
     * @param n the position in Fibonacci sequence
     * @return nth Fibonacci number
     */
    public static long fibonacciMemo(int n) {
        long[] memo = new long[n + 1];
        return fibonacciMemoHelper(n, memo);
    }

    /**
     * Helper method for memoization
     * @param n the position in Fibonacci sequence
     * @param memo array to store computed values
     * @return nth Fibonacci number
     */
    private static long fibonacciMemoHelper(int n, long[] memo) {
        // Base cases
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        // If already computed, return from memo
        if (memo[n] != 0) {
            return memo[n];
        }

        // Compute and store in memo
        memo[n] = fibonacciMemoHelper(n - 1, memo) + fibonacciMemoHelper(n - 2, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        // Test case 1
        int n1 = 6;
        System.out.println("Input: " + n1);
        System.out.println("Output: " + fibonacci(n1));
        System.out.println("Output (Memo): " + fibonacciMemo(n1));
        System.out.println("Expected: 8\n");

        // Test case 2
        int n2 = 1;
        System.out.println("Input: " + n2);
        System.out.println("Output: " + fibonacci(n2));
        System.out.println("Output (Memo): " + fibonacciMemo(n2));
        System.out.println("Expected: 1\n");

        // Test case 3
        int n3 = 2;
        System.out.println("Input: " + n3);
        System.out.println("Output: " + fibonacci(n3));
        System.out.println("Output (Memo): " + fibonacciMemo(n3));
        System.out.println("Expected: 1\n");

        // Test case 4
        int n4 = 10;
        System.out.println("Input: " + n4);
        System.out.println("Output (Memo): " + fibonacciMemo(n4));
        System.out.println("Expected: 55\n");

        // Test case 5 - Print Fibonacci sequence
        System.out.println("First 10 Fibonacci numbers:");
        for (int i = 1; i <= 10; i++) {
            System.out.print(fibonacciMemo(i) + " ");
        }
        System.out.println();
    }
}