import java.util.Scanner;

public class SubstringUsingCharAt {
    public static String substringUsingCharAt(String s, int start, int end) {
        if (s == null) return null;
        if (start < 0) start = 0;
        if (end > s.length()) end = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) sb.append(s.charAt(i));
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
        System.out.print("Enter text: ");
        String text = sc.next();
        System.out.print("Enter start index: ");
        int start = sc.nextInt();
        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        String subUser = substringUsingCharAt(text, start, end);
        String subBuiltin;
        try {
            subBuiltin = text.substring(start, end);
        } catch (Exception ex) {
            subBuiltin = "<error: " + ex.getClass().getSimpleName() + ">";
        }

        System.out.println("substringUsingCharAt: " + subUser);
        System.out.println("String.substring: " + subBuiltin);
        System.out.println("Equal: " + compareUsingCharAt(subUser, subBuiltin));
        sc.close();
    }
}