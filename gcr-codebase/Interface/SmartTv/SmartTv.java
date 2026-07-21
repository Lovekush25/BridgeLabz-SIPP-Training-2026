public class SmartTV implements StreamingService, GamingService {

    private String[] movies;
    private String[] games;

    public SmartTV(String[] movies, String[] games) {
        this.movies = movies;
        this.games = games;
    }

    @Override
    public void streamMovie() {
        System.out.println("Available Movies");

        for (String movie : movies) {
            System.out.println(movie);
        }
    }

    @Override
    public void playGame() {
        System.out.println("Available Games");

        for (String game : games) {
            System.out.println(game);
        }
    }

    @Override
    public void showSubscriptionDetails() {
        StreamingService.super.showSubscriptionDetails();
        GamingService.super.showSubscriptionDetails();
    }
}