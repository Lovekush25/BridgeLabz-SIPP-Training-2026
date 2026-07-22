import java.util.Scanner;

public class RockPaperScissors {
    public static String computerChoice() {
        int r = (int) (Math.random() * 3); // 0,1,2
        return r == 0 ? "rock" : (r == 1 ? "paper" : "scissors");
    }

    public static int winner(String p, String c) {
        if (p.equals(c)) return 0; // draw
        if (p.equals("rock") && c.equals("scissors")) return 1;
        if (p.equals("scissors") && c.equals("paper")) return 1;
        if (p.equals("paper") && c.equals("rock")) return 1;
        return -1; // computer wins
    }

    public static String[][] statsTable(String[] playerChoices, String[] compChoices, int[] results) {
        int n = results.length;
        int pWins = 0, cWins = 0, draws = 0;
        for (int r : results) { if (r == 1) pWins++; else if (r == -1) cWins++; else draws++; }
        String[][] out = new String[n+2][4];
        out[0] = new String[]{"Game","Player","Computer","Result"};
        for (int i = 0; i < n; i++) {
            String res = results[i]==1?"Player":(results[i]==-1?"Computer":"Draw");
            out[i+1] = new String[]{String.valueOf(i+1), playerChoices[i], compChoices[i], res};
        }
        double pPct = n==0?0: (100.0 * pWins / n);
        double cPct = n==0?0: (100.0 * cWins / n);
        out[n+1] = new String[]{"Summary","PlayerWins=" + pWins,"ComputerWins=" + cWins,"Player%=" + String.format("%.2f", pPct) + ", Computer%=" + String.format("%.2f", cPct)};
        return out;
    }

    public static void printTable(String[][] table) {
        for (String[] r : table) System.out.println(String.join("\t", r));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of games: ");
        int n = sc.nextInt();
        sc.nextLine();
        String[] player = new String[n];
        String[] comp = new String[n];
        int[] results = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter choice for game " + (i+1) + " (rock/paper/scissors): ");
            String p = sc.next().toLowerCase();
            String c = computerChoice();
            player[i] = p; comp[i] = c; results[i] = winner(p,c);
        }
        String[][] table = statsTable(player, comp, results);
        printTable(table);
        sc.close();
    }
}