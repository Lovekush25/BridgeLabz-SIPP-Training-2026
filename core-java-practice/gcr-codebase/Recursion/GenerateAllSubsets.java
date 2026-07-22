import java.util.ArrayList;
import java.util.List;

/**
 * Generate All Subsets of an Array
 * Given an array, generate all possible subsets recursively.
 *
 * Example:
 * Input: [1, 2]
 * Output:
 * []
 * [1]
 * [2]
 * [1, 2]
 */
public class GenerateAllSubsets {

    /**
     * Generates all subsets of the given array
     * @param nums the input array
     * @return list containing all subsets
     */
    public static List<List<Integer>> generateSubsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }

        generateSubsetsHelper(nums, 0, new ArrayList<>(), result);
        return result;
    }

    /**
     * Helper method for recursion
     * @param nums the input array
     * @param index current index
     * @param currentSubset current subset being built
     * @param result list to store all subsets
     */
    private static void generateSubsetsHelper(int[] nums, int index,
                                              List<Integer> currentSubset, List<List<Integer>> result) {

        // Base case: if we've processed all elements
        if (index == nums.length) {
            // Add current subset to result
            result.add(new ArrayList<>(currentSubset));
            return;
        }

        // Include current element and recurse
        currentSubset.add(nums[index]);
        generateSubsetsHelper(nums, index + 1, currentSubset, result);

        // Exclude current element and recurse
        currentSubset.remove(currentSubset.size() - 1);
        generateSubsetsHelper(nums, index + 1, currentSubset, result);
    }

    /**
     * Alternative approach using bit manipulation
     * @param nums the input array
     * @return list containing all subsets
     */
    public static List<List<Integer>> generateSubsetsBitwise(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // Total number of subsets = 2^n
        int totalSubsets = 1 << nums.length;

        for (int i = 0; i < totalSubsets; i++) {
            List<Integer> subset = new ArrayList<>();

            for (int j = 0; j < nums.length; j++) {
                // Check if jth bit is set in i
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }

            result.add(subset);
        }

        return result;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = { 1, 2 };
        System.out.println("Input: [1, 2]");
        System.out.println("Output (Recursive):");
        List<List<Integer>> result1 = generateSubsets(nums1);
        for (List<Integer> subset : result1) {
            System.out.println(subset);
        }
        System.out.println();

        // Test case 2
        int[] nums2 = { 1, 2, 3 };
        System.out.println("Input: [1, 2, 3]");
        System.out.println("Output (Bitwise):");
        List<List<Integer>> result2 = generateSubsetsBitwise(nums2);
        for (List<Integer> subset : result2) {
            System.out.println(subset);
        }
        System.out.println();

        // Test case 3
        int[] nums3 = { 5 };
        System.out.println("Input: [5]");
        System.out.println("Output (Recursive):");
        List<List<Integer>> result3 = generateSubsets(nums3);
        for (List<Integer> subset : result3) {
            System.out.println(subset);
        }
        System.out.println();

        // Test case 4
        int[] nums4 = {};
        System.out.println("Input: []");
        System.out.println("Output (Recursive):");
        List<List<Integer>> result4 = generateSubsets(nums4);
        for (List<Integer> subset : result4) {
            System.out.println(subset);
        }
    }
}