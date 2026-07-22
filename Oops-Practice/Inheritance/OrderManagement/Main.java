public class Main {

    public static void main(String[] args) {

        Order o =
                new Order(101,
                        "20 June");

        ShippedOrder so =
                new ShippedOrder(
                        102,
                        "22 June",
                        "TR12345");

        DeliveredOrder d =
                new DeliveredOrder(
                        103,
                        "23 June",
                        "TR98765",
                        "25 June");

        System.out.println(o.getOrderStatus());
        System.out.println(so.getOrderStatus());
        System.out.println(d.getOrderStatus());
    }
}