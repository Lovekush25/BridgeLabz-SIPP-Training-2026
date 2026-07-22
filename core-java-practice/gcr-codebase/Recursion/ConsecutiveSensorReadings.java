/**
 * Consecutive Sensor Readings
 * A sensor records temperature readings every minute.
 * Task: Recursively determine whether the readings are strictly increasing.
 *
 * Example:
 * Input: [12, 15, 18, 22, 30]
 * Output: true
 *
 * Input: [12, 15, 14, 22]
 * Output: false
 */
public class ConsecutiveSensorReadings {

    /**
     * Recursively checks if readings are strictly increasing
     * @param readings array of sensor readings
     * @return true if strictly increasing, false otherwise
     */
    public static boolean isStrictlyIncreasing(int[] readings) {
        if (readings == null || readings.length == 0) {
            return true;
        }
        return isStrictlyIncreasingHelper(readings, 0);
    }

    /**
     * Helper method for recursion
     * @param readings array of sensor readings
     * @param index current index to check
     * @return true if from index to end is strictly increasing
     */
    private static boolean isStrictlyIncreasingHelper(int[] readings, int index) {
        // Base case: if we've reached the last element, it's strictly increasing
        if (index == readings.length - 1) {
            return true;
        }

        // Check if current element is less than next element
        if (readings[index] >= readings[index + 1]) {
            return false;
        }

        // Recursively check the rest
        return isStrictlyIncreasingHelper(readings, index + 1);
    }

    public static void main(String[] args) {
        // Test case 1: Strictly increasing
        int[] readings1 = { 12, 15, 18, 22, 30 };
        System.out.println("Input: [12, 15, 18, 22, 30]");
        System.out.println("Output: " + isStrictlyIncreasing(readings1));
        System.out.println("Expected: true\n");

        // Test case 2: Not strictly increasing
        int[] readings2 = { 12, 15, 14, 22 };
        System.out.println("Input: [12, 15, 14, 22]");
        System.out.println("Output: " + isStrictlyIncreasing(readings2));
        System.out.println("Expected: false\n");

        // Test case 3: Single element
        int[] readings3 = { 25 };
        System.out.println("Input: [25]");
        System.out.println("Output: " + isStrictlyIncreasing(readings3));
        System.out.println("Expected: true\n");

        // Test case 4: Two elements increasing
        int[] readings4 = { 10, 20 };
        System.out.println("Input: [10, 20]");
        System.out.println("Output: " + isStrictlyIncreasing(readings4));
        System.out.println("Expected: true\n");

        // Test case 5: Two elements not increasing
        int[] readings5 = { 20, 10 };
        System.out.println("Input: [20, 10]");
        System.out.println("Output: " + isStrictlyIncreasing(readings5));
        System.out.println("Expected: false\n");

        // Test case 6: Equal elements
        int[] readings6 = { 15, 15, 20 };
        System.out.println("Input: [15, 15, 20]");
        System.out.println("Output: " + isStrictlyIncreasing(readings6));
        System.out.println("Expected: false");
    }
}