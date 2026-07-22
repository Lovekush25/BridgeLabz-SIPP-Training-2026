/**
 * Calculate Power(x,n)
 * Compute x^n using recursion.
 *
 * Example:
 * Input: x = 2, n = 5
 * Output: 32 (2^5 = 2 * 2 * 2 * 2 * 2)
 */
public class CalculatePower {

    /**
     * Recursively calculates x^n (basic approach)
     * @param x the base
     * @param n the exponent
     * @return x raised to power n
     */
    public static long power(int x, int n) {
        // Base case: any number raised to 0 is 1
        if (n == 0) {
            return 1;
        }

        // Base case: any number raised to 1 is itself
        if (n == 1) {
            return x;
        }

        // Recursive case: x^n = x * x^(n-1)
        return x * power(x, n - 1);
    }

    /**
     * Optimized approach using divide and conquer
     * Time complexity: O(log n) instead of O(n)
     * @param x the base
     * @param n the exponent
     * @return x raised to power n
     */
    public static long powerOptimized(int x, int n) {
        // Base case: any number raised to 0 is 1
        if (n == 0) {
            return 1;
        }

        // Recursive case
        long half = powerOptimized(x, n / 2);

        if (n % 2 == 0) {
            // If n is even: x^n = (x^(n/2))^2
            return half * half;
        } else {
            // If n is odd: x^n = x * (x^(n/2))^2
            return x * half * half;
        }
    }

    /**
     * Calculates power with negative exponent support
     * @param x the base
     * @param n the exponent (can be negative)
     * @return x raised to power n
     */
    public static double powerWithNegative(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        if (n < 0) {
            return 1.0 / powerWithNegative(x, -n);
        }

        long half = n / 2;
        double temp = powerWithNegative(x, (int) half);

        if (n % 2 == 0) {
            return temp * temp;
        } else {
            return x * temp * temp;
        }
    }

    public static void main(String[] args) {
        // Test case 1
        int x1 = 2, n1 = 5;
        System.out.println("Input: x = " + x1 + ", n = " + n1);
        System.out.println("Output (Basic): " + power(x1, n1));
        System.out.println("Output (Optimized): " + powerOptimized(x1, n1));
        System.out.println("Expected: 32\n");

        // Test case 2
        int x2 = 3, n2 = 4;
        System.out.println("Input: x = " + x2 + ", n = " + n2);
        System.out.println("Output (Optimized): " + powerOptimized(x2, n2));
        System.out.println("Expected: 81\n");

        // Test case 3
        int x3 = 5, n3 = 0;
        System.out.println("Input: x = " + x3 + ", n = " + n3);
        System.out.println("Output (Optimized): " + powerOptimized(x3, n3));
        System.out.println("Expected: 1\n");

        // Test case 4
        int x4 = 2, n4 = 1;
        System.out.println("Input: x = " + x4 + ", n = " + n4);
        System.out.println("Output (Optimized): " + powerOptimized(x4, n4));
        System.out.println("Expected: 2\n");

        // Test case 5 - Negative exponent
        double x5 = 2.0;
        int n5 = -3;
        System.out.println("Input: x = " + x5 + ", n = " + n5);
        System.out.println("Output: " + powerWithNegative(x5, n5));
        System.out.println("Expected: 0.125\n");

        // Test case 6 - Large power
        int x6 = 10, n6 = 10;
        System.out.println("Input: x = " + x6 + ", n = " + n6);
        System.out.println("Output (Optimized): " + powerOptimized(x6, n6));
        System.out.println("Expected: 10000000000");
    }
}