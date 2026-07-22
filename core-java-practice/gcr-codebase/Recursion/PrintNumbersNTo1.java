/**
 * Print Numbers from N to 1
 * Write a recursive function to print numbers from N to 1.
 *
 * Example:
 * Input: N = 5
 * Output: 5 4 3 2 1
 */
public class PrintNumbersNTo1 {

    /**
     * Recursively prints numbers from n to 1
     * @param n the starting number
     */
    public static void printNumbers(int n) {
        // Base case: if n is 0 or less, stop recursion
        if (n <= 0) {
            return;
        }

        // Print current number
        System.out.print(n + " ");

        // Recursively call with n-1
        printNumbers(n - 1);
    }

    public static void main(String[] args) {
        // Test case 1
        System.out.println("Input: N = 5");
        System.out.print("Output: ");
        printNumbers(5);
        System.out.println("\n");

        // Test case 2
        System.out.println("Input: N = 10");
        System.out.print("Output: ");
        printNumbers(10);
        System.out.println("\n");

        // Test case 3
        System.out.println("Input: N = 1");
        System.out.print("Output: ");
        printNumbers(1);
        System.out.println();
    }
}