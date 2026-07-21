public interface GroceryDelivery {

    void deliverGroceries(String customerName);

    default void trackOrder() {
        System.out.println("Grocery Order Status : Out for Delivery");
    }
}