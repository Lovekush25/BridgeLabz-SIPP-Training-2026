import java.util.Scanner;

public class EmployeeAttendance {

    public static void sort(int[] employeeIds, int[] attendance) {

        int n = employeeIds.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - 1 - i; j++) {

                if (attendance[j] < attendance[j + 1] ||
                   (attendance[j] == attendance[j + 1] &&
                    employeeIds[j] > employeeIds[j + 1])) {

                    int tempAttendance = attendance[j];
                    attendance[j] = attendance[j + 1];
                    attendance[j + 1] = tempAttendance;

                    int tempId = employeeIds[j];
                    employeeIds[j] = employeeIds[j + 1];
                    employeeIds[j + 1] = tempId;
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        int[] employeeIds = new int[n];
        int[] attendance = new int[n];

        System.out.println("Enter Employee IDs:");

        for (int i = 0; i < n; i++) {
            employeeIds[i] = sc.nextInt();
        }

        System.out.println("Enter Attendance:");

        for (int i = 0; i < n; i++) {
            attendance[i] = sc.nextInt();
        }

        System.out.print("Enter K: ");
        int k = sc.nextInt();

        sort(employeeIds, attendance);

        System.out.println("Top " + k + " Employees:");

        for (int i = 0; i < k; i++) {
            System.out.print(employeeIds[i] + " ");
        }
    }
}