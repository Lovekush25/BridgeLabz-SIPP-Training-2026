import java.util.Scanner;

public class UnitConverterLength {

    private static final double YARDS_TO_FEET = 3;
    private static final double FEET_TO_YARDS = 0.333333;
    private static final double METERS_TO_INCHES = 39.3701;
    private static final double INCHES_TO_METERS = 0.0254;
    private static final double INCHES_TO_CM = 2.54;

    public static double convertYardsToFeet(double yards) {
        return yards * YARDS_TO_FEET;
    }

    public static double convertFeetToYards(double feet) {
        return feet * FEET_TO_YARDS;
    }

    public static double convertMetersToInches(double meters) {
        return meters * METERS_TO_INCHES;
    }

    public static double convertInchesToMeters(double inches) {
        return inches * INCHES_TO_METERS;
    }

    public static double convertInchesToCentimeters(double inches) {
        return inches * INCHES_TO_CM;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Unit Converter (Length) ---");
            System.out.println("1. Convert Yards to Feet");
            System.out.println("2. Convert Feet to Yards");
            System.out.println("3. Convert Meters to Inches");
            System.out.println("4. Convert Inches to Meters");
            System.out.println("5. Convert Inches to Centimeters");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter yards: ");
                    double yards = scanner.nextDouble();
                    System.out.println(yards + " yards = " + convertYardsToFeet(yards) + " feet");
                    break;
                case 2:
                    System.out.print("Enter feet: ");
                    double feet = scanner.nextDouble();
                    System.out.println(feet + " feet = " + convertFeetToYards(feet) + " yards");
                    break;
                case 3:
                    System.out.print("Enter meters: ");
                    double meters = scanner.nextDouble();
                    System.out.println(meters + " meters = " + convertMetersToInches(meters) + " inches");
                    break;
                case 4:
                    System.out.print("Enter inches: ");
                    double inches = scanner.nextDouble();
                    System.out.println(inches + " inches = " + convertInchesToMeters(inches) + " meters");
                    break;
                case 5:
                    System.out.print("Enter inches: ");
                    double inchesForCm = scanner.nextDouble();
                    System.out.println(inchesForCm + " inches = " + convertInchesToCentimeters(inchesForCm) + " cm");
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 6);

        scanner.close();
    }
}