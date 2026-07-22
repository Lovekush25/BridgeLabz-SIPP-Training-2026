import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FrequencyChars2D {
    public static String[][] frequency2D(String s) {
        int[] freq = new int[256];
        for (int i = 0; i < s.length(); i++) freq[s.charAt(i)]++;
        List<String[]> list = new ArrayList<>();
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) list.add(new String[]{String.valueOf((char) i), String.valueOf(freq[i])});
        }
        return list.toArray(new String[0][0]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String t = sc.nextLine();
        String[][] table = frequency2D(t);
        System.out.println("Char\tFreq");
        for (String[] r : table) System.out.println(r[0] + "\t" + r[1]);
        sc.close();
    }
}