/**
 * Reverse a String Using Recursion
 * Write a recursive function to reverse a given string.
 *
 * Example:
 * Input: "hello"
 * Output: "olleh"
 */
public class ReverseString {

    /**
     * Recursively reverses a string
     * @param str the string to reverse
     * @return reversed string
     */
    public static String reverseString(String str) {
        // Base case: if string is empty or has single character
        if (str == null || str.length() <= 1) {
            return str;
        }

        // Recursive case: last character + reverse of remaining string
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    /**
     * Alternative approach using index
     * @param str the string to reverse
     * @param start starting index
     * @param end ending index
     */
    public static void reverseStringInPlace(char[] str, int start, int end) {
        // Base case: if start >= end, we're done
        if (start >= end) {
            return;
        }

        // Swap characters at start and end
        char temp = str[start];
        str[start] = str[end];
        str[end] = temp;

        // Recursively reverse remaining string
        reverseStringInPlace(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        // Test case 1
        String str1 = "hello";
        System.out.println("Input: \"" + str1 + "\"");
        System.out.println("Output: \"" + reverseString(str1) + "\"");
        System.out.println("Expected: \"olleh\"\n");

        // Test case 2
        String str2 = "madam";
        System.out.println("Input: \"" + str2 + "\"");
        System.out.println("Output: \"" + reverseString(str2) + "\"");
        System.out.println("Expected: \"madam\"\n");

        // Test case 3
        String str3 = "a";
        System.out.println("Input: \"" + str3 + "\"");
        System.out.println("Output: \"" + reverseString(str3) + "\"");
        System.out.println("Expected: \"a\"\n");

        // Test case 4
        String str4 = "abc";
        System.out.println("Input: \"" + str4 + "\"");
        System.out.println("Output: \"" + reverseString(str4) + "\"");
        System.out.println("Expected: \"cba\"\n");

        // Test case 5 - using in-place reversal
        String str5 = "programming";
        char[] chars = str5.toCharArray();
        System.out.println("Input: \"" + str5 + "\"");
        reverseStringInPlace(chars, 0, chars.length - 1);
        System.out.println("Output: \"" + new String(chars) + "\"");
        System.out.println("Expected: \"gnimmargorP\"");
    }
}