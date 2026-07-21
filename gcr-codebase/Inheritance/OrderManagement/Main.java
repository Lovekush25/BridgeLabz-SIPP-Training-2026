public class Main {
    public static void main(String[] args) {
        Order order = new Order("O101", "24-06-2026");
        ShippedOrder shipped = new ShippedOrder("O102", "24-06-2026", "TRK123");
        DeliveredOrder delivered = new DeliveredOrder(
                "O103",
                "24-06-2026",
                "TRK456",
                "26-06-2026"
        );

        System.out.println(order.getOrderStatus());
        System.out.println(shipped.getOrderStatus());
        System.out.println(delivered.getOrderStatus());
    }
}