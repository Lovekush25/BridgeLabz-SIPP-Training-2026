import java.util.Arrays;

public class EmployeeAttendanceRanking {

    public static void main(String[] args) {

        int[] employeeIds = {101, 102, 103, 104, 105};
        int[] attendance = {92, 85, 98, 92, 80};

        int k = 3;

        // Bubble Sort
        for (int i = 0; i < attendance.length - 1; i++) {

            for (int j = 0; j < attendance.length - 1 - i; j++) {

                if (attendance[j] < attendance[j + 1] ||
                        (attendance[j] == attendance[j + 1] &&
                                employeeIds[j] > employeeIds[j + 1])) {

                    // Swap attendance
                    int temp = attendance[j];
                    attendance[j] = attendance[j + 1];
                    attendance[j + 1] = temp;

                    // Swap employee IDs
                    temp = employeeIds[j];
                    employeeIds[j] = employeeIds[j + 1];
                    employeeIds[j + 1] = temp;
                }
            }
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = employeeIds[i];
        }

        System.out.println("Top " + k + " Employees:");
        System.out.println(Arrays.toString(result));
    }
}