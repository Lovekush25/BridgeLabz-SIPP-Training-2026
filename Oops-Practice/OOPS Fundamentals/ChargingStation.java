class ChargingStation {

    static int totalStations = 0;
    static double electricityRate = 12.5;

    String stationId;
    double unitsConsumed;

    ChargingStation(String stationId, double unitsConsumed) {
        this.stationId = stationId;
        this.unitsConsumed = unitsConsumed;
        totalStations++;
    }

    double calculateBill() {
        return unitsConsumed * electricityRate;
    }

    void displayStationDetails() {
        System.out.println("Station : " + stationId);
        System.out.println("Units   : " + unitsConsumed);
        System.out.println("Bill    : ₹" + calculateBill());
        System.out.println();
    }

    public static void main(String[] args) {

        ChargingStation s1 = new ChargingStation("S1",100);
        ChargingStation s2 = new ChargingStation("S2",150);
        ChargingStation s3 = new ChargingStation("S3",200);
        ChargingStation s4 = new ChargingStation("S4",175);
        ChargingStation s5 = new ChargingStation("S5",90);

        s1.displayStationDetails();
        s2.displayStationDetails();
        s3.displayStationDetails();
        s4.displayStationDetails();
        s5.displayStationDetails();

        electricityRate = 15;

        System.out.println("After Rate Change");

        s1.displayStationDetails();

        System.out.println("Total Stations = " + totalStations);
    }
}