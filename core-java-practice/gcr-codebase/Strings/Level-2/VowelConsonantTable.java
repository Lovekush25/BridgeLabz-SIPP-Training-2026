import java.util.Scanner;

public class VowelConsonantTable {
    public static String charType(char ch) {
        char c = ch;
        if (c >= 'A' && c <= 'Z') c = (char) (c + 32);
        if (c >= 'a' && c <= 'z') {
            if (c=='a'||c=='e'||c=='i'||c=='o'||c=='u') return "Vowel";
            return "Consonant";
        }
        return "Not a Letter";
    }

    public static String[][] classifyChars(String s) {
        if (s == null) return new String[0][0];
        String[][] out = new String[s.length()][2];
        for (int i = 0; i < s.length(); i++) {
            out[i][0] = String.valueOf(s.charAt(i));
            out[i][1] = charType(s.charAt(i));
        }
        return out;
    }

    public static void printTable(String[][] table) {
        System.out.println("Char\tType");
        for (String[] r : table) System.out.println(r[0] + "\t" + r[1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String line = sc.nextLine();
        String[][] table = classifyChars(line);
        printTable(table);
        sc.close();
    }
}