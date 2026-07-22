/**
 * Username Validator
 * A platform requires usernames to contain only lowercase letters.
 * Task: Recursively verify whether a username is valid.
 *
 * Example:
 * Input: "abcdxyz"
 * Output: true
 *
 * Input: "abcD123"
 * Output: false
 */
public class UsernameValidator {

    /**
     * Recursively checks if username is valid (only lowercase letters)
     * @param username the username to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidUsername(String username) {
        if (username == null || username.length() == 0) {
            return false;
        }
        return isValidUsernameHelper(username, 0);
    }

    /**
     * Helper method for recursion
     * @param username the username to validate
     * @param index current character index
     * @return true if all characters are lowercase letters
     */
    private static boolean isValidUsernameHelper(String username, int index) {
        // Base case: if we've checked all characters, it's valid
        if (index == username.length()) {
            return true;
        }

        char currentChar = username.charAt(index);

        // Check if current character is a lowercase letter
        if (currentChar < 'a' || currentChar > 'z') {
            return false;
        }

        // Recursively check the rest
        return isValidUsernameHelper(username, index + 1);
    }

    public static void main(String[] args) {
        // Test case 1: Valid username
        String username1 = "abcdxyz";
        System.out.println("Input: \"" + username1 + "\"");
        System.out.println("Output: " + isValidUsername(username1));
        System.out.println("Expected: true\n");

        // Test case 2: Invalid username with uppercase and digits
        String username2 = "abcD123";
        System.out.println("Input: \"" + username2 + "\"");
        System.out.println("Output: " + isValidUsername(username2));
        System.out.println("Expected: false\n");

        // Test case 3: Valid single lowercase letter
        String username3 = "a";
        System.out.println("Input: \"" + username3 + "\"");
        System.out.println("Output: " + isValidUsername(username3));
        System.out.println("Expected: true\n");

        // Test case 4: Invalid single uppercase letter
        String username4 = "A";
        System.out.println("Input: \"" + username4 + "\"");
        System.out.println("Output: " + isValidUsername(username4));
        System.out.println("Expected: false\n");

        // Test case 5: Invalid with spaces
        String username5 = "abc def";
        System.out.println("Input: \"" + username5 + "\"");
        System.out.println("Output: " + isValidUsername(username5));
        System.out.println("Expected: false\n");

        // Test case 6: Invalid with numbers
        String username6 = "abc123";
        System.out.println("Input: \"" + username6 + "\"");
        System.out.println("Output: " + isValidUsername(username6));
        System.out.println("Expected: false\n");

        // Test case 7: Invalid with special characters
        String username7 = "abc@xyz";
        System.out.println("Input: \"" + username7 + "\"");
        System.out.println("Output: " + isValidUsername(username7));
        System.out.println("Expected: false\n");

        // Test case 8: Valid longer username
        String username8 = "longlowercase";
        System.out.println("Input: \"" + username8 + "\"");
        System.out.println("Output: " + isValidUsername(username8));
        System.out.println("Expected: true");
    }
}