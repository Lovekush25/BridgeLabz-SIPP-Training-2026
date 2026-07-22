import java.util.Scanner;

public class ToLowerUsingCharAt {
    public static String toLowerManual(String s) {
        if (s == null) return null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') c = (char) (c + 32);
            sb.append(c);
        }
        return sb.toString();
    }

    public static boolean compareUsingCharAt(String a, String b) {
        if (a == null || b == null) return a == b;
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) if (a.charAt(i) != b.charAt(i)) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text (use nextLine to include spaces): ");
        String text = sc.nextLine();
        String manual = toLowerManual(text);
        String builtin = text.toLowerCase();
        System.out.println("manual: " + manual);
        System.out.println("builtin: " + builtin);
        System.out.println("Equal: " + compareUsingCharAt(manual, builtin));
        sc.close();
    }
}