import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {
    public static void generateException(String s) {
        // Accessing charAt beyond length
        System.out.println(s.charAt(s.length()));
    }

    public static void handleException(String s) {
        try {
            System.out.println(s.charAt(s.length()));
        } catch (StringIndexOutOfBoundsException ex) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Caught other exception: " + ex.getClass().getSimpleName());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.next();
        try {
            generateException(s);
        } catch (StringIndexOutOfBoundsException ex) {
            System.out.println("Generator threw: " + ex.getClass().getSimpleName());
        }
        System.out.println("Calling handler now:");
        handleException(s);
        sc.close();
    }
}