import java.util.Scanner;

public class NumberFormatDemo {
    public static void generateException(String text) {
        int x = Integer.parseInt(text);
        System.out.println("Parsed: " + x);
    }

    public static void handleException(String text) {
        try {
            generateException(text);
        } catch (NumberFormatException ex) {
            System.out.println("Caught NumberFormatException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Caught RuntimeException: " + ex.getClass().getSimpleName());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text to parse as integer: ");
        String t = sc.next();
        try {
            generateException(t);
        } catch (NumberFormatException ex) {
            System.out.println("Generator threw: " + ex.getClass().getSimpleName());
        }
        System.out.println("Calling handler:");
        handleException(t);
        sc.close();
    }
}