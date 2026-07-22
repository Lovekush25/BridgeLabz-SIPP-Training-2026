import java.util.Scanner;

public class UnitConverterTemperatureWeight {

    private static final double POUNDS_TO_KG = 0.453592;
    private static final double KG_TO_POUNDS = 2.20462;
    private static final double GALLONS_TO_LITERS = 3.78541;
    private static final double LITERS_TO_GALLONS = 0.264172;

    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double convertPoundsToKilograms(double pounds) {
        return pounds * POUNDS_TO_KG;
    }

    public static double convertKilogramsToPounds(double kilograms) {
        return kilograms * KG_TO_POUNDS;
    }

    public static double convertGallonsToLiters(double gallons) {
        return gallons * GALLONS_TO_LITERS;
    }

    public static double convertLitersToGallons(double liters) {
        return liters * LITERS_TO_GALLONS;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Unit Converter (Temperature, Weight, Volume) ---");
            System.out.println("1. Convert Fahrenheit to Celsius");
            System.out.println("2. Convert Celsius to Fahrenheit");
            System.out.println("3. Convert Pounds to Kilograms");
            System.out.println("4. Convert Kilograms to Pounds");
            System.out.println("5. Convert Gallons to Liters");
            System.out.println("6. Convert Liters to Gallons");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Fahrenheit: ");
                    double fahrenheit = scanner.nextDouble();
                    System.out.println(fahrenheit + "°F = " + convertFahrenheitToCelsius(fahrenheit) + "°C");
                    break;
                case 2:
                    System.out.print("Enter Celsius: ");
                    double celsius = scanner.nextDouble();
                    System.out.println(celsius + "°C = " + convertCelsiusToFahrenheit(celsius) + "°F");
                    break;
                case 3:
                    System.out.print("Enter pounds: ");
                    double pounds = scanner.nextDouble();
                    System.out.println(pounds + " lbs = " + convertPoundsToKilograms(pounds) + " kg");
                    break;
                case 4:
                    System.out.print("Enter kilograms: ");
                    double kilograms = scanner.nextDouble();
                    System.out.println(kilograms + " kg = " + convertKilogramsToPounds(kilograms) + " lbs");
                    break;
                case 5:
                    System.out.print("Enter gallons: ");
                    double gallons = scanner.nextDouble();
                    System.out.println(gallons + " gallons = " + convertGallonsToLiters(gallons) + " liters");
                    break;
                case 6:
                    System.out.print("Enter liters: ");
                    double liters = scanner.nextDouble();
                    System.out.println(liters + " liters = " + convertLitersToGallons(liters) + " gallons");
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 7);

        scanner.close();
    }
}