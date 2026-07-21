public class DeliveryExecutive implements FoodDelivery, GroceryDelivery {

    @Override
    public void deliverFood(String customerName) {
        System.out.println("Food delivered to " + customerName);
    }

    @Override
    public void deliverGroceries(String customerName) {
        System.out.println("Groceries delivered to " + customerName);
    }

    @Override
    public void trackOrder() {
        FoodDelivery.super.trackOrder();
        GroceryDelivery.super.trackOrder();
    }

    public void processDeliveries(String[] customers) {

        for (String customer : customers) {

            System.out.println();

            System.out.println("Customer : " + customer);
            System.out.println("Delivery Code : " + FoodDelivery.generateDeliveryCode());

            trackOrder();

            deliverFood(customer);
            deliverGroceries(customer);

        }

    }

}