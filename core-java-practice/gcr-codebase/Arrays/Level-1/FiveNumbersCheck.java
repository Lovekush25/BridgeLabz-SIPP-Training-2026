import java.util.Scanner;

public class FiveNumbersCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[5];
        System.out.println("Enter 5 integers:");
        for (int i = 0; i < a.length; i++) a[i] = sc.nextInt();

        for (int num : a) {
            if (num > 0) {
                if (num % 2 == 0) System.out.println(num + " is positive even.");
                else System.out.println(num + " is positive odd.");
            } else if (num < 0) {
                System.out.println(num + " is negative.");
            } else {
                System.out.println(num + " is zero.");
            }
        }

        int first = a[0], last = a[a.length - 1];
        if (first == last) System.out.println("First element is equal to last element.");
        else if (first > last) System.out.println("First element is greater than last element.");
        else System.out.println("First element is less than last element.");

        sc.close();
    }
}