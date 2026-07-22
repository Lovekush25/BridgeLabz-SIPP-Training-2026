import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer number: ");
        long n = sc.nextLong();
        long num = Math.abs(n);
        int[] digits = new int[20];
        int idx = 0;
        while (num != 0) {
            if (idx == digits.length) {
                int[] t = new int[digits.length + 10];
                System.arraycopy(digits, 0, t, 0, digits.length);
                digits = t;
            }
            digits[idx++] = (int) (num % 10);
            num /= 10;
        }

        System.out.println("Digits in reverse order:");
        for (int i = 0; i < idx; i++) System.out.print(digits[i]);
        if (idx == 0) System.out.print(0);
        System.out.println();
        sc.close();
    }
}