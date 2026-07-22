import java.util.Scanner;

public class StudentGrades2DArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[][] marks = new int[n][3]; // 0: physics,1:chem,2:maths
        double[] percent = new double[n];
        String[] grade = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Student " + (i + 1) + " Physics: ");
            int p = sc.nextInt();
            System.out.print("Chemistry: ");
            int c = sc.nextInt();
            System.out.print("Maths: ");
            int m = sc.nextInt();
            if (p < 0 || c < 0 || m < 0) {
                System.out.println("Negative marks not allowed. Enter again.");
                i--;
                continue;
            }
            marks[i][0] = p;
            marks[i][1] = c;
            marks[i][2] = m;
            percent[i] = (p + c + m) / 3.0;
            double perc = percent[i];
            if (perc >= 90) grade[i] = "A";
            else if (perc >= 80) grade[i] = "B";
            else if (perc >= 70) grade[i] = "C";
            else if (perc >= 60) grade[i] = "D";
            else grade[i] = "F";
        }

        System.out.println("Std\tPhy\tChem\tMaths\t%\tGrade");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d\t%d\t%d\t%d\t%.2f\t%s%n", i + 1, marks[i][0], marks[i][1], marks[i][2], percent[i], grade[i]);
        }
        sc.close();
    }
}