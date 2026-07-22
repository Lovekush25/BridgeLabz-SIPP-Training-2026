import java.util.Scanner;

public class VowelConsonantCount {
    public static String charType(char ch) {
        char c = ch;
        if (c >= 'A' && c <= 'Z') c = (char) (c + 32);
        if (c >= 'a' && c <= 'z') {
            if (c=='a'||c=='e'||c=='i'||c=='o'||c=='u') return "Vowel";
            return "Consonant";
        }
        return "Not a Letter";
    }

    public static int[] countVowelsConsonants(String s) {
        int v = 0, c = 0;
        if (s == null) return new int[]{0,0};
        for (int i = 0; i < s.length(); i++) {
            String t = charType(s.charAt(i));
            if (t.equals("Vowel")) v++;
            else if (t.equals("Consonant")) c++;
        }
        return new int[]{v, c};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String line = sc.nextLine();
        int[] res = countVowelsConsonants(line);
        System.out.println("Vowels: " + res[0]);
        System.out.println("Consonants: " + res[1]);
        sc.close();
    }
}