import java.util.Scanner;

public class WindChillCalculator {

    public static double calculateWindChill(double temperature, double windSpeed) {
        // Wind chill formula: 35.74 + 0.6215T - 35.75(V^0.16) + 0.4275T(V^0.16)
        // T is temperature in Fahrenheit, V is wind speed in mph
        double windChill = 35.74 + (0.6215 * temperature) - (35.75 * Math.pow(windSpeed, 0.16)) +
                (0.4275 * temperature * Math.pow(windSpeed, 0.16));
        return windChill;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter temperature (in Fahrenheit): ");
        double temperature = scanner.nextDouble();

        System.out.print("Enter wind speed (in mph): ");
        double windSpeed = scanner.nextDouble();

        double windChill = calculateWindChill(temperature, windSpeed);

        System.out.println("Wind Chill Temperature: " + windChill + " F");

        scanner.close();
    }
}