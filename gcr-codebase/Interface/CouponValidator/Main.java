public class Main {

    public static void main(String[] args) {

        String[] coupons = {
                "SAVE10",
                "SAVE50",
                "OFF20",
                "SAVE100",
                "ABC",
                "SAVE5"
        };

        ShoppingCart cart = new ShoppingCart();

        cart.checkCoupons(coupons);

    }
}