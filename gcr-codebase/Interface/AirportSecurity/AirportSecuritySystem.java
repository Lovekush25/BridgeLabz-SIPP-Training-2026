public class AirportSecuritySystem implements LuggageScanner, PassportVerifier {

    @Override
    public void scanLuggage(String passengerName) {
        System.out.println(passengerName + " luggage scanned successfully.");
    }

    @Override
    public void verifyPassport(String passportNo) {

        if (PassportVerifier.isPassportNumberValid(passportNo)) {
            System.out.println("Passport Verified");
        } else {
            System.out.println("Invalid Passport");
        }

    }

    @Override
    public void displaySecurityGuidelines() {

        LuggageScanner.super.displaySecurityGuidelines();
        PassportVerifier.super.displaySecurityGuidelines();

    }

    public void processPassengers(String[] names, String[] passportNumbers) {

        for (int i = 0; i < names.length; i++) {

            System.out.println();

            System.out.println("Passenger : " + names[i]);

            scanLuggage(names[i]);

            verifyPassport(passportNumbers[i]);

            if (PassportVerifier.isPassportNumberValid(passportNumbers[i])) {
                System.out.println("Boarding Status : Allowed");
            } else {
                System.out.println("Boarding Status : Not Allowed");
            }

        }

    }

}