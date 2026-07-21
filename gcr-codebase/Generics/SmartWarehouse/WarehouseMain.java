public class WarehouseMain {

    public static void main(String[] args) {

        Storage<Electronics> electronicsStorage = new Storage<>();

        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Camera"));
        electronicsStorage.addItem(new Electronics("Printer"));

        Storage<Groceries> groceryStorage = new Storage<>();

        groceryStorage.addItem(new Groceries("Rice"));
        groceryStorage.addItem(new Groceries("Sugar"));
        groceryStorage.addItem(new Groceries("Milk"));

        Storage<Furniture> furnitureStorage = new Storage<>();

        furnitureStorage.addItem(new Furniture("Chair"));
        furnitureStorage.addItem(new Furniture("Table"));

        System.out.println("Electronics");

        WarehouseUtility.displayItems(electronicsStorage.getItems());

        System.out.println();

        System.out.println("Groceries");

        WarehouseUtility.displayItems(groceryStorage.getItems());

        System.out.println();

        System.out.println("Furniture");

        WarehouseUtility.displayItems(furnitureStorage.getItems());
    }
}