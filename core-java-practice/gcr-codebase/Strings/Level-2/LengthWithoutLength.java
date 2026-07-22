import java.util.Scanner;

public class LengthWithoutLength {
    public static int lengthWithout(String s) {
        if (s == null) return -1;
        int count = 0;
        try {
            while (true) {
                s.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException ex) {
            // reached end
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String text = sc.next();
        int manual = lengthWithout(text);
        int builtin = text.length();
        System.out.println("Manual length: " + manual);
        System.out.println("Builtin length: " + builtin);
        System.out.println("Equal: " + (manual == builtin));
        sc.close();
    }
}