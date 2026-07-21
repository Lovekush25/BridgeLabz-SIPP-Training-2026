public class Main {

    public static void main(String[] args) {

        String[] passengers = {
                "Kishan",
                "Rahul",
                "Aman",
                "Neha",
                "Priya"
        };

        String[] passportNumbers = {
                "AB123456",
                "P12345",
                "XY987654",
                "AA111111",
                "123"
        };

        AirportSecuritySystem system = new AirportSecuritySystem();

        system.displaySecurityGuidelines();

        system.processPassengers(passengers, passportNumbers);

    }

}