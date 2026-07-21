import java.util.Scanner;

public class IllegalArgumentDemo {

    static void generateException(String text) {
        System.out.println(text.substring(5, 2));
    }

    static void handleException(String text) {
        try {
            System.out.println(text.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException Handled");
        } catch (RuntimeException e) {
            System.out.println("Runtime Exception Handled");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String: ");
        String text = sc.next();

        // generateException(text);

        handleException(text);
    }
}