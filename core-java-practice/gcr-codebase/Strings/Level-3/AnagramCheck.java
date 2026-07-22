import java.util.Scanner;

public class AnagramCheck {
    public static boolean isAnagram(String a, String b) {
        if (a == null || b == null) return a == b;
        if (a.length() != b.length()) return false;
        int[] freq = new int[256];
        for (int i = 0; i < a.length(); i++) freq[a.charAt(i)]++;
        for (int i = 0; i < b.length(); i++) freq[b.charAt(i)]--;
        for (int v : freq) if (v != 0) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first text: ");
        String a = sc.nextLine();
        System.out.print("Enter second text: ");
        String b = sc.nextLine();
        System.out.println("Anagram: " + isAnagram(a, b));
        sc.close();
    }
}