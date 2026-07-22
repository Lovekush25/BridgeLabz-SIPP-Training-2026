import java.util.Scanner;

public class YoungestAndTallest {

    public static int findYoungest(int[] ages) {
        int minAge = ages[0];
        int youngestIndex = 0;

        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < minAge) {
                minAge = ages[i];
                youngestIndex = i;
            }
        }

        return youngestIndex;
    }

    public static int findTallest(double[] heights) {
        double maxHeight = heights[0];
        int tallestIndex = 0;

        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > maxHeight) {
                maxHeight = heights[i];
                tallestIndex = i;
            }
        }

        return tallestIndex;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] friendNames = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        System.out.println("Enter age and height for 3 friends:");
        for (int i = 0; i < 3; i++) {
            System.out.println("\nFor " + friendNames[i] + ":");
            System.out.print("Enter age: ");
            ages[i] = scanner.nextInt();

            System.out.print("Enter height (in cm): ");
            heights[i] = scanner.nextDouble();
        }

        int youngestIndex = findYoungest(ages);
        int tallestIndex = findTallest(heights);

        System.out.println("\n--- Results ---");
        System.out.println("Youngest friend: " + friendNames[youngestIndex] + " (Age: " + ages[youngestIndex] + ")");
        System.out.println("Tallest friend: " + friendNames[tallestIndex] + " (Height: " + heights[tallestIndex] + " cm)");

        scanner.close();
    }
}