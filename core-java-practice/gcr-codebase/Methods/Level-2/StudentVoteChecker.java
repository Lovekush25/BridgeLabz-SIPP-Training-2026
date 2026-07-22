import java.util.Scanner;

public class StudentVoteChecker {

    public boolean canStudentVote(int age) {
        if (age < 0) {
            return false;
        }
        return age >= 18;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentVoteChecker checker = new StudentVoteChecker();

        int[] studentAges = new int[10];

        System.out.println("Enter ages of 10 students:");
        for (int i = 0; i < studentAges.length; i++) {
            System.out.print("Student " + (i + 1) + " age: ");
            studentAges[i] = scanner.nextInt();

            boolean canVote = checker.canStudentVote(studentAges[i]);

            if (studentAges[i] < 0) {
                System.out.println("Invalid age for Student " + (i + 1));
            } else if (canVote) {
                System.out.println("Student " + (i + 1) + " CAN VOTE (Age: " + studentAges[i] + ")");
            } else {
                System.out.println("Student " + (i + 1) + " CANNOT VOTE (Age: " + studentAges[i] + ")");
            }
        }

        scanner.close();
    }
}