import java.util.ArrayList;
import java.util.List;

public class MarketplaceMain {

    public static void main(String[] args) {

        Product<BookCategory> javaBook =
                new Product<>("Java Programming", 850, new BookCategory());

        Product<ClothingCategory> tshirt =
                new Product<>("Black T-Shirt", 1200, new ClothingCategory());

        Product<GadgetCategory> headphones =
                new Product<>("Wireless Headphones", 3500, new GadgetCategory());

        MarketplaceUtility.applyDiscount(javaBook, 10);
        MarketplaceUtility.applyDiscount(tshirt, 20);
        MarketplaceUtility.applyDiscount(headphones, 15);

        List<Product<?>> products = new ArrayList<>();

        products.add(javaBook);
        products.add(tshirt);
        products.add(headphones);

        MarketplaceUtility.displayProducts(products);
    }
}