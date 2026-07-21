class Item {
    int itemCode;
    String itemName;
    double price;

    double totalCost(int qty) {
        return price * qty;
    }

    void display() {
        System.out.println(itemCode);
        System.out.println(itemName);
        System.out.println(price);
    }

    public static void main(String[] args) {
        Item i = new Item();
        i.itemCode = 1;
        i.itemName = "Pen";
        i.price = 10;
        i.display();
        System.out.println(i.totalCost(5));
    }
}