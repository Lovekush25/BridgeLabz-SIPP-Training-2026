import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    static LinkedList<String> playlist = new LinkedList<>();

    public static void playSong(String song) {

        playlist.remove(song);

        playlist.addFirst(song);

        if (playlist.size() > 10) {
            playlist.removeLast();
        }

        System.out.println("Now Playing : " + song);
    }

    public static void searchSong(String song) {

        if (playlist.contains(song)) {
            System.out.println("Song Found in Recently Played.");
        } else {
            System.out.println("Song Not Found.");
        }
    }

    public static void displayPlaylist() {

        if (playlist.isEmpty()) {
            System.out.println("Recently Played List is Empty.");
            return;
        }

        System.out.println("\n===== Recently Played =====");

        int index = 1;

        for (String song : playlist) {
            System.out.println(index + ". " + song);
            index++;
        }

        System.out.println("----------------------------");
        System.out.println("Total Songs : " + playlist.size());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Music Playlist Recommendation Engine =====");
            System.out.println("1. Play Song");
            System.out.println("2. Search Song");
            System.out.println("3. Display Recently Played");
            System.out.println("4. Exit");

            System.out.print("Enter Choice : ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Song Name : ");
                    playSong(sc.nextLine());
                    break;

                case 2:

                    System.out.print("Enter Song Name : ");
                    searchSong(sc.nextLine());
                    break;

                case 3:

                    displayPlaylist();
                    break;

                case 4:

                    System.out.println("Thank You.");
                    sc.close();
                    return;

                default:

                    System.out.println("Invalid Choice.");
            }
        }
    }
}