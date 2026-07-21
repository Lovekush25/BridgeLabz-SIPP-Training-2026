import java.util.Arrays;

public class ProductPrices {

    public static void main(String[] args) {

        int[] prices = {450, 120, 780, 300, 250, 600};

        // Bubble Sort
        for (int i = 0; i < prices.length - 1; i++) {

            for (int j = 0; j < prices.length - 1 - i; j++) {

                if (prices[j] > prices[j + 1]) {

                    int temp = prices[j];
                    prices[j] = prices[j + 1];
                    prices[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(prices));
    }
}