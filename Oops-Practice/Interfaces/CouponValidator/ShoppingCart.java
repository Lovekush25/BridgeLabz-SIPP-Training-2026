class ShoppingCart implements CouponValidator {

    @Override
    public boolean validateCoupon(String code) {

        return CouponValidator.isLengthValid(code)
                && code.startsWith("SAVE");
    }
}