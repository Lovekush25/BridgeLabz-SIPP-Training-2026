import java.util.List;

public class MarketplaceUtility {

    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {

        double discount = product.getPrice() * percentage / 100;
        product.setPrice(product.getPrice() - discount);
    }

    public static void displayProducts(List<? extends Product<?>> products) {

        for (Product<?> product : products) {
            System.out.println(product);
        }
    }
}