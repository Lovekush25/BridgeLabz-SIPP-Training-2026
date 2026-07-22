import java.util.Scanner;

public class RecursiveNaturalNumberSum {

    public static long sumRecursive(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumRecursive(n - 1);
    }

    public static long sumFormula(int n) {
        return (long) n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Error: Please enter a natural number (greater than 0)");
        } else {
            long recursiveSum = sumRecursive(n);
            long formulaSum = sumFormula(n);

            System.out.println("Sum using Recursive Method: " + recursiveSum);
            System.out.println("Sum using Formula n*(n+1)/2: " + formulaSum);

            if (recursiveSum == formulaSum) {
                System.out.println("Both computations are CORRECT! Results match.");
            } else {
                System.out.println("Results do NOT match. There is an error.");
            }
        }

        scanner.close();
    }
}