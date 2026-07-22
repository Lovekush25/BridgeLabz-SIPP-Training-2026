import java.util.Arrays;
import java.util.Scanner;

public class UniqueCharacters {
    public static int lengthWithout(String s) {
        if (s == null) return -1;
        int c = 0;
        try { while (true) { s.charAt(c); c++; } } catch (IndexOutOfBoundsException ex) {}
        return c;
    }

    public static char[] uniqueChars(String s) {
        int len = lengthWithout(s);
        char[] temp = new char[len];
        int ucount = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            boolean found = false;
            for (int j = 0; j < i; j++) if (s.charAt(j) == c) { found = true; break; }
            if (!found) { temp[ucount++] = c; }
        }
        return Arrays.copyOf(temp, ucount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String t = sc.nextLine();
        char[] u = uniqueChars(t);
        System.out.println("Unique chars: " + Arrays.toString(u));
        sc.close();
    }
}