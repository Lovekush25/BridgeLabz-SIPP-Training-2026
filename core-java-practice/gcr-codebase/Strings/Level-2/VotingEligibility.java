import java.util.Random;
import java.util.Scanner;

public class VotingEligibility {
    public static int[] generateAges(int n) {
        Random r = new Random();
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) ages[i] = 10 + r.nextInt(90); // 10..99
        return ages;
    }

    public static String[][] eligibilityTable(int[] ages) {
        String[][] out = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            out[i][0] = String.valueOf(ages[i]);
            if (ages[i] < 0) out[i][1] = "false";
            else out[i][1] = (ages[i] >= 18) ? "true" : "false";
        }
        return out;
    }

    public static void printTable(String[][] table) {
        System.out.println("Age\tCanVote");
        for (String[] r : table) System.out.println(r[0] + "\t" + r[1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many students? ");
        int n = sc.nextInt();
        int[] ages = generateAges(n);
        String[][] table = eligibilityTable(ages);
        printTable(table);
        sc.close();
    }
}