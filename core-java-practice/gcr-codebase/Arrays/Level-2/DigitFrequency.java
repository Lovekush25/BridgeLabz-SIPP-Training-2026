import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer number: ");
        long num = Math.abs(sc.nextLong());
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

        int[] freq = new int[10];
        for (int i = 0; i < idx; i++) freq[digits[i]]++;

        System.out.println("Digit frequencies:");
        for (int d = 0; d <= 9; d++) System.out.println(d + " -> " + freq[d]);
        sc.close();
    }
}