import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SplitCompareManual {
    public static String[] splitManual(String text) {
        if (text == null) return new String[0];
        List<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == ' ') {
                if (sb.length() > 0) {
                    words.add(sb.toString());
                    sb.setLength(0);
                }
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0) words.add(sb.toString());
        return words.toArray(new String[0]);
    }

    public static boolean compareArrays(String[] a, String[] b) {
        if (a == null || b == null) return a == b;
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) if (!a[i].equals(b[i])) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a line of text: ");
        String line = sc.nextLine();
        String[] manual = splitManual(line);
        String[] builtin = line.trim().isEmpty() ? new String[0] : line.split("\\s+");
        System.out.println("manual: " + Arrays.toString(manual));
        System.out.println("builtin: " + Arrays.toString(builtin));
        System.out.println("Equal: " + compareArrays(manual, builtin));
        sc.close();
    }
}