class SmartTV implements StreamingService, GamingService {

    @Override
    public void streamMovie() {
        System.out.println("Streaming movie...");
    }

    @Override
    public void playGame() {
        System.out.println("Launching game...");
    }

    @Override
    public void showSubscriptionDetails() {

        StreamingService.super.showSubscriptionDetails();
        GamingService.super.showSubscriptionDetails();
    }
}