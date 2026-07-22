import java.util.Scanner;

public class GreatestFactorWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int i = number - 1;

        while (i >= 1) {
            if (number % i == 0) {
                System.out.println(i);
                break;
            }
            i--;
        }
        sc.close();
    }
}