import java.util.Scanner;

public class SubstringDemo {

    static String createSubstring(String text, int start, int end) {
        String result = "";

        for (int i = start; i < end; i++) {
            result += text.charAt(i);
        }

        return result;
    }

    static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.next();

        System.out.print("Start index: ");
        int start = sc.nextInt();

        System.out.print("End index: ");
        int end = sc.nextInt();

        String userSub = createSubstring(text, start, end);
        String builtSub = text.substring(start, end);

        System.out.println("User Substring: " + userSub);
        System.out.println("Built-in Substring: " + builtSub);
        System.out.println("Equal: " + compareStrings(userSub, builtSub));
    }
}