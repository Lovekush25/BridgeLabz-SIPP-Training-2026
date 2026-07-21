package SubscriptionAnalyzer;

public class Subscription {
    String subscriberName;
    String subscriptionId;

    public Subscription(String subscriberName, String subscriptionId) {
        this.subscriberName = subscriberName;
        this.subscriptionId = subscriptionId;
    }

    public double calculateMonthlyCharge() {
        return 0;
    }
}