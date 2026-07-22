/**
 * Check Palindrome Using Recursion
 * Determine whether a string is palindrome using recursion.
 *
 * Example:
 * Input: "madam"
 * Output: Palindrome
 */
public class CheckPalindrome {

    /**
     * Recursively checks if a string is palindrome
     * @param str the string to check
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        return isPalindromeHelper(str.toLowerCase(), 0, str.length() - 1);
    }

    /**
     * Helper method for recursion
     * @param str the string to check
     * @param start starting index
     * @param end ending index
     * @return true if palindrome, false otherwise
     */
    private static boolean isPalindromeHelper(String str, int start, int end) {
        // Base case: if start >= end, it's a palindrome
        if (start >= end) {
            return true;
        }

        // Check if characters at start and end are same
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursively check remaining string
        return isPalindromeHelper(str, start + 1, end - 1);
    }

    /**
     * Checks palindrome ignoring spaces and special characters
     * @param str the string to check
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindromeAdvanced(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }

        // Remove non-alphanumeric characters and convert to lowercase
        String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return isPalindromeHelper(cleaned, 0, cleaned.length() - 1);
    }

    public static void main(String[] args) {
        // Test case 1
        String str1 = "madam";
        System.out.println("Input: \"" + str1 + "\"");
        System.out.println("Output: " + (isPalindrome(str1) ? "Palindrome" : "Not Palindrome"));
        System.out.println("Expected: Palindrome\n");

        // Test case 2
        String str2 = "hello";
        System.out.println("Input: \"" + str2 + "\"");
        System.out.println("Output: " + (isPalindrome(str2) ? "Palindrome" : "Not Palindrome"));
        System.out.println("Expected: Not Palindrome\n");

        // Test case 3
        String str3 = "racecar";
        System.out.println("Input: \"" + str3 + "\"");
        System.out.println("Output: " + (isPalindrome(str3) ? "Palindrome" : "Not Palindrome"));
        System.out.println("Expected: Palindrome\n");

        // Test case 4
        String str4 = "a";
        System.out.println("Input: \"" + str4 + "\"");
        System.out.println("Output: " + (isPalindrome(str4) ? "Palindrome" : "Not Palindrome"));
        System.out.println("Expected: Palindrome\n");

        // Test case 5 - Advanced (with spaces and punctuation)
        String str5 = "A man, a plan, a canal: Panama";
        System.out.println("Input: \"" + str5 + "\"");
        System.out.println("Output: " + (isPalindromeAdvanced(str5) ? "Palindrome" : "Not Palindrome"));
        System.out.println("Expected: Palindrome\n");

        // Test case 6 - Advanced
        String str6 = "race a car";
        System.out.println("Input: \"" + str6 + "\"");
        System.out.println("Output: " + (isPalindromeAdvanced(str6) ? "Palindrome" : "Not Palindrome"));
        System.out.println("Expected: Not Palindrome");
    }
}