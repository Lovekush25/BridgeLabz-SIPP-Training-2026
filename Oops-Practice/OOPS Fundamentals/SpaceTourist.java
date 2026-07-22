class SpaceTourist {

    static int totalReservations = 0;
    static String missionName = "Mars Mission";

    String touristName;
    int seatNumber;

    SpaceTourist(String touristName, int seatNumber) {
        this.touristName = touristName;
        this.seatNumber = seatNumber;
        totalReservations++;
    }

    SpaceTourist updateSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
        return this;
    }

    void displayDetails() {
        System.out.println("Mission : " + missionName);
        System.out.println("Tourist : " + touristName);
        System.out.println("Seat    : " + seatNumber);
        System.out.println();
    }

    public static void main(String[] args) {

        SpaceTourist t1 = new SpaceTourist("Rahul",5);

        t1.updateSeatNumber(10)
                .updateSeatNumber(15);

        t1.displayDetails();

        System.out.println("Total Reservations = " + totalReservations);
    }
}