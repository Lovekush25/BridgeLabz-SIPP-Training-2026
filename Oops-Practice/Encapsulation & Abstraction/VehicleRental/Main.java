public class Main {

    public static void main(String[] args) {

        Car car = new Car();
        car.setVehicleNumber("DL01C1234");
        car.setVehicleType("Car");
        car.setDailyRate(2000);

        Bike bike = new Bike();
        bike.setVehicleNumber("DL02B5678");
        bike.setVehicleType("Bike");
        bike.setDailyRate(500);

        Truck truck = new Truck();
        truck.setVehicleNumber("DL03T9999");
        truck.setVehicleType("Truck");
        truck.setDailyRate(4000);
        truck.setLoadingCharge(2000);

        int days = 5;

        car.displayVehicleInfo();
        System.out.println("Cost = " + car.calculateRentalCost(days));

        System.out.println();

        bike.displayVehicleInfo();
        System.out.println("Cost = " + bike.calculateRentalCost(days));

        System.out.println();

        truck.displayVehicleInfo();
        System.out.println("Cost = " + truck.calculateRentalCost(days));
    }
}