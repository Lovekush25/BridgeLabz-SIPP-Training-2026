import java.util.Scanner;

public class MultiplesFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        if (number > 0 && number < 100) {
            for (int i = number; i < 100; i += number) {
                System.out.println(i);
            }
        }

        sc.close();
    }
}