import java.util.Scanner;

public class MaximumHandshakes {

    public static long calculateHandshakes(int numberOfStudents) {
        return (long) (numberOfStudents * (numberOfStudents - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int numberOfStudents = scanner.nextInt();

        long handshakes = calculateHandshakes(numberOfStudents);

        System.out.println("Maximum number of possible handshakes: " + handshakes);

        scanner.close();
    }
}