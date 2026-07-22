import java.util.Scanner;

public class ShortestLongestWords {
    public static String[] splitManual(String text) {
        if (text == null) return new String[0];
        java.util.List<String> words = new java.util.ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == ' ') { if (sb.length() > 0) { words.add(sb.toString()); sb.setLength(0); } }
            else sb.append(c);
        }
        if (sb.length() > 0) words.add(sb.toString());
        return words.toArray(new String[0]);
    }

    public static int lengthWithout(String s) {
        if (s == null) return -1;
        int c = 0; try { while (true) { s.charAt(c); c++; } } catch (IndexOutOfBoundsException ex) {}
        return c;
    }

    public static String[][] wordsWithLengths(String[] words) {
        String[][] out = new String[words.length][2];
        for (int i = 0; i < words.length; i++) { out[i][0] = words[i]; out[i][1] = String.valueOf(lengthWithout(words[i])); }
        return out;
    }

    // returns [shortestIndex, longestIndex]
    public static int[] findShortestLongest(String[][] table) {
        if (table.length == 0) return new int[]{-1, -1};
        int shortest = 0, longest = 0;
        for (int i = 1; i < table.length; i++) {
            int len = Integer.parseInt(table[i][1]);
            if (len < Integer.parseInt(table[shortest][1])) shortest = i;
            if (len > Integer.parseInt(table[longest][1])) longest = i;
        }
        return new int[]{shortest, longest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String line = sc.nextLine();
        String[] words = splitManual(line);
        String[][] table = wordsWithLengths(words);
        int[] idx = findShortestLongest(table);
        if (idx[0] >= 0) {
            System.out.println("Shortest: " + table[idx[0]][0] + " (" + table[idx[0]][1] + ")");
            System.out.println("Longest: " + table[idx[1]][0] + " (" + table[idx[1]][1] + ")");
        } else {
            System.out.println("No words found.");
        }
        sc.close();
    }
}