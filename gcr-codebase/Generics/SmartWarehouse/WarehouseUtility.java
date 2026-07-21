import java.util.List;

public class WarehouseUtility {

    public static void displayItems(List<? extends WarehouseItem> items) {

        for (WarehouseItem item : items) {
            System.out.println(item);
        }

    }
}