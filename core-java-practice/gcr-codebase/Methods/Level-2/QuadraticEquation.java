import java.util.Scanner;

public class QuadraticEquation {

    public static double[] findRoots(double a, double b, double c) {
        double delta = (b * b) - (4 * a * c);

        if (delta > 0) {
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            return new double[]{root1, root2};
        } else if (delta == 0) {
            double root = -b / (2 * a);
            return new double[]{root};
        } else {
            return new double[]{}; // Empty array for negative delta
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quadratic Equation: ax² + bx + c = 0");
        System.out.print("Enter a: ");
        double a = scanner.nextDouble();

        System.out.print("Enter b: ");
        double b = scanner.nextDouble();

        System.out.print("Enter c: ");
        double c = scanner.nextDouble();

        if (a == 0) {
            System.out.println("Error: 'a' cannot be zero for a quadratic equation");
        } else {
            double[] roots = findRoots(a, b, c);

            if (roots.length == 2) {
                System.out.println("Two roots exist:");
                System.out.println("Root 1: " + roots[0]);
                System.out.println("Root 2: " + roots[1]);
            } else if (roots.length == 1) {
                System.out.println("One root exists:");
                System.out.println("Root: " + roots[0]);
            } else {
                System.out.println("No real roots exist (Delta is negative)");
            }
        }

        scanner.close();
    }
}