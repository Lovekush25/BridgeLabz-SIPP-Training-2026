import java.util.Scanner;

public class TriangularParkRuns {

    public static double calculatePerimeter(double side1, double side2, double side3) {
        return side1 + side2 + side3;
    }

    public static int calculateNumberOfRounds(double perimeter) {
        double totalDistance = 5000; // 5 km in meters
        return (int) (totalDistance / perimeter);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter side 1 of triangle (in meters): ");
        double side1 = scanner.nextDouble();

        System.out.print("Enter side 2 of triangle (in meters): ");
        double side2 = scanner.nextDouble();

        System.out.print("Enter side 3 of triangle (in meters): ");
        double side3 = scanner.nextDouble();

        double perimeter = calculatePerimeter(side1, side2, side3);
        int rounds = calculateNumberOfRounds(perimeter);

        System.out.println("Perimeter of triangle: " + perimeter + " meters");
        System.out.println("Number of rounds to complete 5 km run: " + rounds);

        scanner.close();
    }
}