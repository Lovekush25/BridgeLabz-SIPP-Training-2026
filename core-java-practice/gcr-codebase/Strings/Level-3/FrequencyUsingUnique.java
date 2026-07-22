import java.util.Arrays;
import java.util.Scanner;

public class FrequencyUsingUnique {
    public static char[] uniqueChars(String s) {
        int len = s.length();
        char[] temp = new char[len];
        int uc = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            boolean found = false;
            for (int j = 0; j < i; j++) if (s.charAt(j) == c) { found = true; break; }
            if (!found) temp[uc++] = c;
        }
        return Arrays.copyOf(temp, uc);
    }

    public static String[][] freqUsingUnique(String s) {
        int[] freq = new int[256];
        for (int i = 0; i < s.length(); i++) freq[s.charAt(i)]++;
        char[] u = uniqueChars(s);
        String[][] out = new String[u.length][2];
        for (int i = 0; i < u.length; i++) {
            out[i][0] = String.valueOf(u[i]);
            out[i][1] = String.valueOf(freq[u[i]]);
        }
        return out;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String t = sc.nextLine();
        String[][] table = freqUsingUnique(t);
        System.out.println("Char\tFreq");
        for (String[] r : table) System.out.println(r[0] + "\t" + r[1]);
        sc.close();
    }
}