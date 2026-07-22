import java.util.Scanner;

public class SumOfNaturalNumbers {

    public static long calculateSum(int n) {
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = scanner.nextInt();

        long sum = calculateSum(n);

        System.out.println("Sum of first " + n + " natural numbers: " + sum);

        scanner.close();
    }
}