public class Main {

    public static void main(String[] args) {

        String[] coupons = {
                "SAVE10",
                "OFF20",
                "SAVE50",
                "AB",
                "SAVE100"
        };

        ShoppingCart cart = new ShoppingCart();

        for (String code : coupons) {

            if (cart.validateCoupon(code)) {
                System.out.println(code + " : Valid");
            }
            else {
                System.out.println(code + " : Invalid");
            }
        }
    }
}