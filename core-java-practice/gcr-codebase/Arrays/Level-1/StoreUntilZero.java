import java.util.Scanner;

public class StoreUntilZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] arr = new double[10];
        int idx = 0;
        System.out.println("Enter numbers (enter 0 or negative to stop):");
        while (true) {
            if (idx == 10) break;
            double v = sc.nextDouble();
            if (v <= 0) break;
            arr[idx++] = v;
        }

        double sum = 0.0;
        System.out.println("Numbers entered:");
        for (int i = 0; i < idx; i++) {
            System.out.println(arr[i]);
            sum += arr[i];
        }
        System.out.println("Sum = " + sum);
        sc.close();
    }
}