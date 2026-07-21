public interface LuggageScanner {

    void scanLuggage(String passengerName);

    default void displaySecurityGuidelines() {
        System.out.println("Security Guideline : Keep prohibited items out of luggage.");
    }
}