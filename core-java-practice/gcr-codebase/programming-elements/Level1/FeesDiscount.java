public class FeesDiscount{
    public static void main(String[] args){
        double fee = 125000;
        int discountPercent = 10;
        double discount = ( fee * discountPercent ) / 100;
        double payableFee = fee - discount;
        System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR " + payableFee);
    }
}