class MobilePhone {
    String brand;
    String model;
    double price;

    void display() {
        System.out.println(brand);
        System.out.println(model);
        System.out.println(price);
    }

    public static void main(String[] args) {
        MobilePhone m = new MobilePhone();
        m.brand = "Samsung";
        m.model = "S21";
        m.price = 70000;
        m.display();
    }
}