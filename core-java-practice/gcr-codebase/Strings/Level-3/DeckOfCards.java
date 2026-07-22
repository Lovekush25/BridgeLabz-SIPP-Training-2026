import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DeckOfCards {
    public static String[] initDeck() {
        String[] suits = {"Hearts","Diamonds","Clubs","Spades"};
        String[] ranks = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
        String[] deck = new String[suits.length * ranks.length];
        int idx = 0;
        for (String r : ranks) for (String s : suits) deck[idx++] = r + " of " + s;
        return deck;
    }

    public static void shuffle(String[] deck) {
        int n = deck.length;
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            int r = i + rnd.nextInt(n - i);
            String tmp = deck[i]; deck[i] = deck[r]; deck[r] = tmp;
        }
    }

    public static String[][] distribute(String[] deck, int numCards, int players) {
        if (numCards > deck.length) return new String[0][];
        if (numCards % players != 0) return new String[0][]; // require equal distribution
        int per = numCards / players;
        String[][] out = new String[players][per];
        int idx = 0;
        for (int p = 0; p < players; p++) {
            for (int c = 0; c < per; c++) out[p][c] = deck[idx++];
        }
        return out;
    }

    public static void printPlayers(String[][] players) {
        for (int i = 0; i < players.length; i++) System.out.println("Player " + (i+1) + ": " + Arrays.toString(players[i]));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] deck = initDeck();
        shuffle(deck);
        System.out.print("Enter number of cards to distribute: ");
        int n = sc.nextInt();
        System.out.print("Enter number of players: ");
        int p = sc.nextInt();
        String[][] players = distribute(deck, n, p);
        if (players.length == 0) System.out.println("Cannot distribute cards evenly or invalid number");
        else printPlayers(players);
        sc.close();
    }
}