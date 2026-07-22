import java.util.Scanner;

public class PositiveNegativeEvenOdd {

    public static boolean isPositive(int number) {
        return number > 0;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static int compare(int number1, int number2) {
        if (number1 > number2) {
            return 1;
        } else if (number1 == number2) {
            return 0;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[5];

        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();

            if (isPositive(numbers[i])) {
                System.out.print("Number is POSITIVE ");
                if (isEven(numbers[i])) {
                    System.out.println("and EVEN");
                } else {
                    System.out.println("and ODD");
                }
            } else if (numbers[i] == 0) {
                System.out.println("Number is ZERO");
            } else {
                System.out.println("Number is NEGATIVE");
            }
        }

        System.out.println("\n--- Comparing First and Last Element ---");
        int result = compare(numbers[0], numbers[4]);

        if (result == 1) {
            System.out.println("First element (" + numbers[0] + ") is GREATER than Last element (" + numbers[4] + ")");
        } else if (result == 0) {
            System.out.println("First element (" + numbers[0] + ") is EQUAL to Last element (" + numbers[4] + ")");
        } else {
            System.out.println("First element (" + numbers[0] + ") is LESS than Last element (" + numbers[4] + ")");
        }

        scanner.close();
    }
}