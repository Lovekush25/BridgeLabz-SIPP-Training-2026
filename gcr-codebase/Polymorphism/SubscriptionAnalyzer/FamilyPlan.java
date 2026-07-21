package SubscriptionAnalyzer;

public class FamilyPlan extends Subscription {

    public FamilyPlan(String n, String id) {
        super(n, id);
    }

    public double calculateMonthlyCharge() {
        return 699;
    }
}