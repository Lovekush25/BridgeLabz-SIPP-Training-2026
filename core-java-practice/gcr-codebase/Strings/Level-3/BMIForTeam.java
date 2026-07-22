import java.util.Scanner;

public class BMIForTeam {
    public static String[][] computeBMI(double[][] hw) {
        // hw[i][0]=weight(kg), hw[i][1]=height(cm)
        String[][] out = new String[hw.length][4];
        for (int i = 0; i < hw.length; i++) {
            double weight = hw[i][0];
            double heightM = hw[i][1] / 100.0;
            double bmi = 0.0;
            if (heightM > 0) bmi = weight / (heightM * heightM);
            String status;
            if (bmi == 0) status = "Invalid";
            else if (bmi < 18.5) status = "Underweight";
            else if (bmi < 24.9) status = "Normal";
            else if (bmi < 29.9) status = "Overweight";
            else status = "Obese";
            out[i][0] = String.valueOf((int) hw[i][1]);
            out[i][1] = String.valueOf(weight);
            out[i][2] = String.format("%.2f", bmi);
            out[i][3] = status;
        }
        return out;
    }

    public static void display(String[][] table) {
        System.out.println("Height(cm)\tWeight(kg)\tBMI\tStatus");
        for (String[] r : table) {
            System.out.println(r[0] + "\t\t" + r[1] + "\t\t" + r[2] + "\t" + r[3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 10;
        double[][] hw = new double[n][2];
        for (int i = 0; i < n; i++) {
            System.out.print("Person " + (i+1) + " weight (kg): ");
            hw[i][0] = sc.nextDouble();
            System.out.print("Person " + (i+1) + " height (cm): ");
            hw[i][1] = sc.nextDouble();
        }
        String[][] res = computeBMI(hw);
        display(res);
        sc.close();
    }
}