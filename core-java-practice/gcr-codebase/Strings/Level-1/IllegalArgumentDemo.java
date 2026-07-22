import java.util.Scanner;

public class IllegalArgumentDemo {
    public static void generateException(String s, int start, int end) {
        // Intentionally throw IllegalArgumentException if start > end
        if (start > end) throw new IllegalArgumentException("start index greater than end index");
        // otherwise call substring
        System.out.println("Substring: " + s.substring(start, end));
    }

    public static void handleException(String s, int start, int end) {
        try {
            generateException(s, start, end);
        } catch (IllegalArgumentException ex) {
            System.out.println("Caught IllegalArgumentException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Caught RuntimeException: " + ex.getClass().getSimpleName());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String s = sc.next();
        System.out.print("Enter start index: ");
        int start = sc.nextInt();
        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        try {
            generateException(s, start, end);
        } catch (IllegalArgumentException ex) {
            System.out.println("Generator threw: " + ex.getMessage());
        }
        System.out.println("Calling handler:");
        handleException(s, start, end);
        sc.close();
    }
}