import java.util.Scanner;

public class TrimManual {
    public static int[] trimIndexes(String s) {
        if (s == null) return new int[]{0,0};
        int start = 0, end = s.length();
        while (start < end && s.charAt(start) == ' ') start++;
        while (end > start && s.charAt(end-1) == ' ') end--;
        return new int[]{start, end};
    }

    public static String substringUsingCharAt(String s, int start, int end) {
        if (s == null) return null;
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
        System.out.print("Enter text (with spaces): ");
        String line = sc.nextLine();
        int[] idx = trimIndexes(line);
        String manual = substringUsingCharAt(line, idx[0], idx[1]);
        String builtin = line.trim();
        System.out.println("Manual: '" + manual + "'");
        System.out.println("Builtin: '" + builtin + "'");
        System.out.println("Equal: " + compareUsingCharAt(manual, builtin));
        sc.close();
    }
}