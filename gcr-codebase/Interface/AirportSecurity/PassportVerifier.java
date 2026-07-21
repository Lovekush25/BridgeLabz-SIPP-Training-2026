public interface PassportVerifier {

    void verifyPassport(String passportNo);

    default void displaySecurityGuidelines() {
        System.out.println("Security Guideline : Carry a valid passport.");
    }

    static boolean isPassportNumberValid(String passportNo) {
        return passportNo.length() == 8;
    }
}