import java.util.Scanner;

public class PalindromeChecks {
    public static boolean isPalindromeIterative(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String s, int start, int end) {
        if (start >= end) return true;
        if (s.charAt(start) != s.charAt(end)) return false;
        return isPalindromeRecursive(s, start+1, end-1);
    }

    public static boolean isPalindromeByReverse(String s) {
        char[] rev = new char[s.length()];
        for (int i = 0; i < s.length(); i++) rev[s.length()-1-i] = s.charAt(i);
        char[] orig = s.toCharArray();
        for (int i = 0; i < orig.length; i++) if (orig[i] != rev[i]) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String t = sc.nextLine();
        System.out.println("Iterative: " + isPalindromeIterative(t));
        System.out.println("Recursive: " + isPalindromeRecursive(t, 0, t.length()-1));
        System.out.println("ByReverse: " + isPalindromeByReverse(t));
        sc.close();
    }
}