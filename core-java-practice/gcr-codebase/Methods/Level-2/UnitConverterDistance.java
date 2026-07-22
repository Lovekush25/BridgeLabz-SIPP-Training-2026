import java.util.Scanner;

public class UnitConverterDistance {

    private static final double KM_TO_MILES = 0.621371;
    private static final double MILES_TO_KM = 1.60934;
    private static final double METERS_TO_FEET = 3.28084;
    private static final double FEET_TO_METERS = 0.3048;

    public static double convertKmToMiles(double km) {
        return km * KM_TO_MILES;
    }

    public static double convertMilesToKm(double miles) {
        return miles * MILES_TO_KM;
    }

    public static double convertMetersToFeet(double meters) {
        return meters * METERS_TO_FEET;
    }

    public static double convertFeetToMeters(double feet) {
        return feet * FEET_TO_METERS;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Unit Converter (Distance) ---");
            System.out.println("1. Convert Kilometers to Miles");
            System.out.println("2. Convert Miles to Kilometers");
            System.out.println("3. Convert Meters to Feet");
            System.out.println("4. Convert Feet to Meters");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter kilometers: ");
                    double km = scanner.nextDouble();
                    System.out.println(km + " km = " + convertKmToMiles(km) + " miles");
                    break;
                case 2:
                    System.out.print("Enter miles: ");
                    double miles = scanner.nextDouble();
                    System.out.println(miles + " miles = " + convertMilesToKm(miles) + " km");
                    break;
                case 3:
                    System.out.print("Enter meters: ");
                    double meters = scanner.nextDouble();
                    System.out.println(meters + " meters = " + convertMetersToFeet(meters) + " feet");
                    break;
                case 4:
                    System.out.print("Enter feet: ");
                    double feet = scanner.nextDouble();
                    System.out.println(feet + " feet = " + convertFeetToMeters(feet) + " meters");
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        scanner.close();
    }
}