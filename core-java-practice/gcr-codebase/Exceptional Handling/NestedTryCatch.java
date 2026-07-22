import java.util.*;

public class NestedTryCatch {
    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40};

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter index: ");
        int index = sc.nextInt();

        System.out.print("Enter divisor: ");
        int divisor = sc.nextInt();

        try {
            try {
                int value = arr[index];
                int result = value / divisor;

                System.out.println("Result = " + result);
            }
            catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        }

        sc.close();
    }
}