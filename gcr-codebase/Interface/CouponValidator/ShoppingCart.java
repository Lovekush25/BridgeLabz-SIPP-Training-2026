public class ShoppingCart implements CouponValidator {

    @Override
    public boolean validateCoupon(String code) {

        if (!CouponValidator.isLengthValid(code)) {
            return false;
        }

        if (!code.startsWith("SAVE")) {
            return false;
        }

        return true;
    }

    public void checkCoupons(String[] coupons) {

        for (String coupon : coupons) {

            if (validateCoupon(coupon)) {
                System.out.println(coupon + " : Valid Coupon");
            } else {
                System.out.println(coupon + " : Invalid Coupon");
            }

        }

    }
}