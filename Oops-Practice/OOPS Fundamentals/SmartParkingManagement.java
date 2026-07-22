class SmartParkingManagement {

    String vehicleNumber;
    String ownerName;
    String vehicleType;

    Vehicle(String vehicleNumber, String ownerName, String vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    static void displayCars(Vehicle arr[]) {

        System.out.println("Cars:");

        for(Vehicle v : arr) {
            if(v.vehicleType.equalsIgnoreCase("Car")) {
                System.out.println(v.vehicleNumber + " - " + v.ownerName);
            }
        }
    }

    static void displayBikes(Vehicle arr[]) {

        System.out.println("Bikes:");

        for(Vehicle v : arr) {
            if(v.vehicleType.equalsIgnoreCase("Bike")) {
                System.out.println(v.vehicleNumber + " - " + v.ownerName);
            }
        }
    }

    public static void main(String[] args) {

        Vehicle arr[] = {

                new Vehicle("DL01","A","Car"),
                new Vehicle("DL02","B","Bike"),
                new Vehicle("DL03","C","Car"),
                new Vehicle("DL04","D","Bike"),
                new Vehicle("DL05","E","Car"),
                new Vehicle("DL06","F","Bike"),
                new Vehicle("DL07","G","Car"),
                new Vehicle("DL08","H","Bike"),
                new Vehicle("DL09","I","Car"),
                new Vehicle("DL10","J","Bike")
        };

        displayCars(arr);
        System.out.println();
        displayBikes(arr);
    }
}