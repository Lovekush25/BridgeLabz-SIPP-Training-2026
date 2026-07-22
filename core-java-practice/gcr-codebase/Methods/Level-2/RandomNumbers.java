public class RandomNumbers {

    public static int[] generate4DigitRandomArray(int size) {
        int[] randomNumbers = new int[size];

        for (int i = 0; i < size; i++) {
            // Generate 4-digit random numbers (1000-9999)
            randomNumbers[i] = 1000 + (int) (Math.random() * 9000);
        }

        return randomNumbers;
    }

    public static double[] findAverageMinMax(int[] numbers) {
        double sum = 0;
        int min = numbers[0];
        int max = numbers[0];

        for (int number : numbers) {
            sum += number;

            if (number < min) {
                min = number;
            }

            if (number > max) {
                max = number;
            }
        }

        double average = sum / numbers.length;
        return new double[]{average, min, max};
    }

    public static void main(String[] args) {
        // Generate 5 four-digit random numbers
        int[] randomArray = generate4DigitRandomArray(5);

        System.out.println("Generated Random Numbers:");
        for (int num : randomArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Find average, min, and max
        double[] results = findAverageMinMax(randomArray);

        System.out.println("\n--- Results ---");
        System.out.println("Average: " + results[0]);
        System.out.println("Minimum: " + (int) results[1]);
        System.out.println("Maximum: " + (int) results[2]);
    }
}