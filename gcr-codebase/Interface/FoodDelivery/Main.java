public class Main {

    public static void main(String[] args) {

        String[] customers = {
                "Kishan",
                "Rahul",
                "Neha",
                "Priya",
                "Aman"
        };

        DeliveryExecutive executive = new DeliveryExecutive();

        executive.processDeliveries(customers);

    }

}