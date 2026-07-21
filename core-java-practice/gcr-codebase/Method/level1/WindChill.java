import java.util.Scanner;

public class WindChill {

    public static double calculateWindChill(double t, double v) {
        return 35.74 + (0.6215 * t)
                - (35.75 * Math.pow(v, 0.16))
                + (0.4275 * t * Math.pow(v, 0.16));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Temperature: ");
        double temp = sc.nextDouble();

        System.out.print("Enter Wind Speed: ");
        double speed = sc.nextDouble();

        System.out.println("Wind Chill = " +
                calculateWindChill(temp, speed));
    }
}