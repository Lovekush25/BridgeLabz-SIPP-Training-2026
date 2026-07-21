package SubscriptionAnalyzer;

public class PremiumPlan extends Subscription {

    public PremiumPlan(String n, String id) {
        super(n, id);
    }

    public double calculateMonthlyCharge() {
        return 499;
    }
}