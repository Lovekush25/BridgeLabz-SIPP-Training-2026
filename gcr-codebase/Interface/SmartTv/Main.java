public class Main {

    public static void main(String[] args) {

        String[] movies = {
                "Avengers",
                "Interstellar",
                "The Dark Knight",
                "Inception",
                "John Wick"
        };

        String[] games = {
                "PUBG",
                "Valorant",
                "GTA V",
                "Minecraft",
                "FIFA 25"
        };

        SmartTV tv = new SmartTV(movies, games);

        tv.showSubscriptionDetails();

        System.out.println();

        tv.streamMovie();

        System.out.println();

        tv.playGame();
    }
}