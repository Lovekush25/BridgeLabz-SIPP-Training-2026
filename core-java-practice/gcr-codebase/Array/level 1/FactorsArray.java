import java.util.Scanner;

public class FactorsArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int number = sc.nextInt();

        int[] factors = new int[number];
        int index = 0;

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }

        System.out.println("Factors:");

        for (int i = 0; i < index; i++) {
            System.out.print(factors[i] + " ");
        }
    }
}