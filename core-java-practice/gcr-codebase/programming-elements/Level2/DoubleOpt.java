import java.util.Scanner;

public class DoubleOpt {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a: ");
        double a = input.nextDouble();

        System.out.print("Enter b: ");
        double b = input.nextDouble();

        System.out.print("Enter c: ");
        double c = input.nextDouble();

        double res1 = a + b * c;
        double res2 = a * b + c;
        double res3 = c + a / b;

        System.out.println("The results of Double Operations are " + res1 + ", " + res2 + ", and " + res3);

        input.close();
    }
}