public class Main {
    public static void main(String[] args) {

        String[] movies = {
                "Avengers",
                "Interstellar",
                "Inception"
        };

        String[] games = {
                "FIFA",
                "Minecraft",
                "GTA V"
        };

        SmartTV tv = new SmartTV();

        tv.showSubscriptionDetails();

        System.out.println();

        System.out.println("Movies");

        for (String movie : movies) {
            System.out.println(movie);
        }

        System.out.println();

        System.out.println("Games");

        for (String game : games) {
            System.out.println(game);
        }
    }
}