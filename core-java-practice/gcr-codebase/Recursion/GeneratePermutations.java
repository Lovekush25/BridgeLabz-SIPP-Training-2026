import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Generate All Permutations of a String
 * Generate all possible permutations of a string recursively.
 *
 * Example:
 * Input: "ABC"
 * Output:
 * ABC
 * ACB
 * BAC
 * BCA
 * CAB
 * CBA
 */
public class GeneratePermutations {

    /**
     * Generates all permutations of the given string
     * @param str the input string
     * @return list containing all permutations
     */
    public static List<String> generatePermutations(String str) {
        List<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            result.add("");
            return result;
        }

        generatePermutationsHelper(str, "", result);
        return result;
    }

    /**
     * Helper method for recursion
     * @param str the remaining characters to permute
     * @param current current permutation being built
     * @param result list to store all permutations
     */
    private static void generatePermutationsHelper(String str, String current, List<String> result) {
        // Base case: if all characters have been used
        if (str.length() == 0) {
            result.add(current);
            return;
        }

        // Try each character as the next character in permutation
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // Remaining string after removing current character
            String remaining = str.substring(0, i) + str.substring(i + 1);

            generatePermutationsHelper(remaining, current + ch, result);
        }
    }

    /**
     * Alternative approach using character array swap
     * @param str the input string
     * @return list containing all permutations
     */
    public static List<String> generatePermutationsSwap(String str) {
        List<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            result.add("");
            return result;
        }

        char[] chars = str.toCharArray();
        generatePermutationsSwapHelper(chars, 0, result);
        return result;
    }

    /**
     * Helper method using swap approach
     * @param chars character array
     * @param index current index
     * @param result list to store all permutations
     */
    private static void generatePermutationsSwapHelper(char[] chars, int index, List<String> result) {
        // Base case: if we've fixed all characters
        if (index == chars.length - 1) {
            result.add(new String(chars));
            return;
        }

        for (int i = index; i < chars.length; i++) {
            // Swap
            char temp = chars[index];
            chars[index] = chars[i];
            chars[i] = temp;

            // Recurse
            generatePermutationsSwapHelper(chars, index + 1, result);

            // Backtrack - swap back
            temp = chars[index];
            chars[index] = chars[i];
            chars[i] = temp;
        }
    }

    /**
     * Generates permutations of a string with duplicate characters
     * @param str the input string
     * @return set containing unique permutations
     */
    public static Set<String> generateUniquePermutations(String str) {
        Set<String> result = new HashSet<>();
        if (str == null || str.length() == 0) {
            result.add("");
            return result;
        }

        char[] chars = str.toCharArray();
        generateUniquePermutationsHelper(chars, 0, result);
        return result;
    }

    /**
     * Helper method for unique permutations
     * @param chars character array
     * @param index current index
     * @param result set to store unique permutations
     */
    private static void generateUniquePermutationsHelper(char[] chars, int index, Set<String> result) {
        if (index == chars.length - 1) {
            result.add(new String(chars));
            return;
        }

        Set<Character> used = new HashSet<>();
        for (int i = index; i < chars.length; i++) {
            // Skip if we've already used this character at this position
            if (used.contains(chars[i])) {
                continue;
            }

            used.add(chars[i]);

            // Swap
            char temp = chars[index];
            chars[index] = chars[i];
            chars[i] = temp;

            // Recurse
            generateUniquePermutationsHelper(chars, index + 1, result);

            // Backtrack
            temp = chars[index];
            chars[index] = chars[i];
            chars[i] = temp;
        }
    }

    public static void main(String[] args) {
        // Test case 1
        String str1 = "ABC";
        System.out.println("Input: \"" + str1 + "\"");
        System.out.println("Output (Recursive):");
        List<String> result1 = generatePermutations(str1);
        for (String perm : result1) {
            System.out.println(perm);
        }
        System.out.println("Total permutations: " + result1.size() + "\n");

        // Test case 2
        String str2 = "AB";
        System.out.println("Input: \"" + str2 + "\"");
        System.out.println("Output (Swap approach):");
        List<String> result2 = generatePermutationsSwap(str2);
        for (String perm : result2) {
            System.out.println(perm);
        }
        System.out.println("Total permutations: " + result2.size() + "\n");

        // Test case 3
        String str3 = "A";
        System.out.println("Input: \"" + str3 + "\"");
        System.out.println("Output (Recursive):");
        List<String> result3 = generatePermutations(str3);
        for (String perm : result3) {
            System.out.println(perm);
        }
        System.out.println("Total permutations: " + result3.size() + "\n");

        // Test case 4 - With duplicate characters
        String str4 = "AAB";
        System.out.println("Input: \"" + str4 + "\" (with duplicates)");
        System.out.println("Output (Unique permutations):");
        Set<String> result4 = generateUniquePermutations(str4);
        for (String perm : result4) {
            System.out.println(perm);
        }
        System.out.println("Total unique permutations: " + result4.size() + "\n");

        // Test case 5
        String str5 = "ABCD";
        System.out.println("Input: \"" + str5 + "\"");
        System.out.println("Output count (Recursive): " + generatePermutations(str5).size());
        System.out.println("Expected: " + factorial(4) + " (4!)");
    }

    /**
     * Helper method to calculate factorial
     * @param n the number
     * @return factorial of n
     */
    private static long factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}