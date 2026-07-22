import java.util.Scanner;

public class ArrayIndexOutOfBoundsDemo {
    public static void generateException(String[] arr, int idx) {
        System.out.println(arr[idx]);
    }

    public static void handleException(String[] arr, int idx) {
        try {
            System.out.println(arr[idx]);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Caught RuntimeException: " + ex.getClass().getSimpleName());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many names? ");
        int n = sc.nextInt();
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name " + i + ": ");
            names[i] = sc.next();
        }
        System.out.print("Enter index to access: ");
        int idx = sc.nextInt();
        try {
            generateException(names, idx);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Generator threw: " + ex.getClass().getSimpleName());
        }
        System.out.println("Calling handler:");
        handleException(names, idx);
        sc.close();
    }
}