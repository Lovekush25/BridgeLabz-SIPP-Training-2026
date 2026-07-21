public interface FoodDelivery {

    void deliverFood(String customerName);

    default void trackOrder() {
        System.out.println("Food Order Status : Out for Delivery");
    }

    static String generateDeliveryCode() {
        return "FD1001";
    }
}