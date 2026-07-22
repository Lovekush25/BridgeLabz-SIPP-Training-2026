import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        double num1, num2;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter first number: ");
        num1 = input.nextDouble();

        System.out.print("Enter second number: ");
        num2 = input.nextDouble();

        double addition = num1 + num2;
        double subtraction = num1 - num2;
        double multiplication = num1 * num2;
        double division = num1 / num2;

        System.out.println("The addition, subtraction, multiplication,  and division value of 2 numbers " + num1 + " and " + num2 + " are " + addition + ", " + subtraction + ", " + multiplication + ", and " + division);

        input.close();
    }
}