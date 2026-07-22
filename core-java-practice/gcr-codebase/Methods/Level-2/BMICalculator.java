import java.util.Scanner;

public class BMICalculator {

    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0]; // in kg
            double heightCm = data[i][1]; // in cm
            double heightM = heightCm / 100; // convert to meters
            double bmi = weight / (heightM * heightM);
            data[i][2] = bmi;
        }
    }

    public static String[] determineBMIStatus(double[][] data) {
        String[] status = new String[data.length];

        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];

            if (bmi < 18.5) {
                status[i] = "Underweight";
            } else if (bmi >= 18.5 && bmi < 25) {
                status[i] = "Normal Weight";
            } else if (bmi >= 25 && bmi < 30) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        return status;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 2D array: rows = 10 people, columns = [weight, height, BMI]
        double[][] data = new double[10][3];

        System.out.println("Enter weight (kg) and height (cm) for 10 team members:");
        for (int i = 0; i < 10; i++) {
            System.out.println("\nTeam Member " + (i + 1) + ":");
            System.out.print("Enter weight (kg): ");
            data[i][0] = scanner.nextDouble();

            System.out.print("Enter height (cm): ");
            data[i][1] = scanner.nextDouble();
        }

        calculateBMI(data);
        String[] bmiStatus = determineBMIStatus(data);

        System.out.println("\n========================================");
        System.out.println("       BMI Details of Team Members");
        System.out.println("========================================");
        System.out.printf("%-8s %-10s %-10s %-10s %-15s%n", "Member", "Weight(kg)", "Height(cm)", "BMI", "Status");
        System.out.println("----------------------------------------");

        for (int i = 0; i < 10; i++) {
            System.out.printf("%-8d %-10.2f %-10.2f %-10.2f %-15s%n",
                    (i + 1), data[i][0], data[i][1], data[i][2], bmiStatus[i]);
        }

        scanner.close();
    }
}