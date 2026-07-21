public class Main {
    public static void main(String[] args) {
        Chef chef = new Chef("Kishan Raghav", 101);
        Waiter waiter = new Waiter("Rahul", 102);

        chef.performDuties();
        waiter.performDuties();
    }
}