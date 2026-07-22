import java.util.Scanner;

public class BMIMultiArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();
        double[][] personData = new double[n][3]; // [weight, height, bmi]
        String[] weightStatus = new String[n];

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
            personData[i][0] = w;
            personData[i][1] = h;
            double b = w / (h * h);
            personData[i][2] = b;
            if (b < 18.5) weightStatus[i] = "Underweight";
            else if (b < 25) weightStatus[i] = "Normal";
            else if (b < 30) weightStatus[i] = "Overweight";
            else weightStatus[i] = "Obese";
        }

        System.out.println("Person\tWeight\tHeight\tBMI\tStatus");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d\t%.2f\t%.2f\t%.2f\t%s%n", i + 1, personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }
        sc.close();
    }
}