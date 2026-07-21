package SubscriptionAnalyzer;

public class BasicPlan extends Subscription {

    public BasicPlan(String n, String id) {
        super(n, id);
    }

    public double calculateMonthlyCharge() {
        return 199;
    }
}