package SubscriptionAnalyzer;

public class Main {
    public static void main(String[] args) {
        Subscription[] s = new Subscription[3];

        s[0] = new BasicPlan("A", "S1");
        s[1] = new PremiumPlan("B", "S2");
        s[2] = new FamilyPlan("C", "S3");

        double total = 0;
        Subscription max = s[0];

        for (Subscription x : s) {
            total += x.calculateMonthlyCharge();

            if (x.calculateMonthlyCharge() > max.calculateMonthlyCharge()) {
                max = x;
            }
        }

        System.out.println(total);
        System.out.println(max.subscriberName);
    }
}