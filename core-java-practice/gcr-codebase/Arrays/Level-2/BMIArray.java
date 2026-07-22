import java.util.Scanner;

public class BMIArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();
        double[] weight = new double[n];
        double[] height = new double[n];
        double[] bmi = new double[n];
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Person " + (i + 1) + " weight (kg): ");
            double w = sc.nextDouble();
            System.out.print("Person " + (i + 1) + " height (m): ");
            double h = sc.nextDouble();
            if (w <= 0 || h <= 0) {
                System.out.println("Invalid values. Enter positive weight and height.");
                i--;
                continue;
            }
            weight[i] = w;
            height[i] = h;
            bmi[i] = w / (h * h);
            double b = bmi[i];
            if (b < 18.5) status[i] = "Underweight";
            else if (b < 25) status[i] = "Normal";
            else if (b < 30) status[i] = "Overweight";
            else status[i] = "Obese";
        }

        System.out.println("Person\tWeight\tHeight\tBMI\tStatus");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d\t%.2f\t%.2f\t%.2f\t%s%n", i + 1, weight[i], height[i], bmi[i], status[i]);
        }
        sc.close();
    }
}