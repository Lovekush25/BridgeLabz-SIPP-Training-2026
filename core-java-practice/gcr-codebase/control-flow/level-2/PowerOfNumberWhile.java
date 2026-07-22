import java.util.Scanner;

public class PowerOfNumberWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        int power = sc.nextInt();
        long result = 1;
        int count = 0;

        while (count < power) {
            result *= number;
            count++;
        }

        System.out.println(result);
        sc.close();
    }
}