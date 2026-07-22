import java.util.Scanner;

public class WordsWithLengths {
    public static String[] splitManual(String text) {
        if (text == null) return new String[0];
        java.util.List<String> words = new java.util.ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == ' ') {
                if (sb.length() > 0) { words.add(sb.toString()); sb.setLength(0); }
            } else sb.append(c);
        }
        if (sb.length() > 0) words.add(sb.toString());
        return words.toArray(new String[0]);
    }

    public static int lengthWithout(String s) {
        if (s == null) return -1;
        int count = 0;
        try { while (true) { s.charAt(count); count++; } } catch (IndexOutOfBoundsException ex) {}
        return count;
    }

    public static String[][] wordsWithLengths(String[] words) {
        String[][] out = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            out[i][0] = words[i];
            out[i][1] = String.valueOf(lengthWithout(words[i]));
        }
        return out;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String line = sc.nextLine();
        String[] words = splitManual(line);
        String[][] table = wordsWithLengths(words);
        System.out.println("Word\tLength");
        for (String[] row : table) {
            System.out.println(row[0] + "\t" + Integer.parseInt(row[1]));
        }
        sc.close();
    }
}