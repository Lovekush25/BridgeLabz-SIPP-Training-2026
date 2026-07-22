import java.util.Scanner;

public class IntOperation {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a: ");
        int a = input.nextInt();

        System.out.print("Enter b: ");
        int b = input.nextInt();

        System.out.print("Enter c: ");
        int c = input.nextInt();

        int result1 = a + b * c;
        int result2 = a * b + c;
        int result3 = c + a / b;

        System.out.println("The results of Int Operations are "
                + result1 + ", "
                + result2 + ", and "
                + result3);

        input.close();
    }
}