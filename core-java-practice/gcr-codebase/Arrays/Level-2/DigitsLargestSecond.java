import java.util.Scanner;

public class DigitsLargestSecond {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer number: ");
        long num = Math.abs(sc.nextLong());
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int idx = 0;

        while (num != 0) {
            if (idx == maxDigit) break; // per original hint
            digits[idx++] = (int) (num % 10);
            num /= 10;
        }

        int largest = -1, second = -1;
        for (int i = 0; i < idx; i++) {
            int d = digits[i];
            if (d > largest) {
                second = largest;
                largest = d;
            } else if (d > second && d != largest) {
                second = d;
            }
        }

        System.out.println("Largest digit: " + (largest >= 0 ? largest : "N/A"));
        System.out.println("Second largest digit: " + (second >= 0 ? second : "N/A"));
        sc.close();
    }
}