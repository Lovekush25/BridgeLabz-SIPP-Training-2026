public interface SpamDetection {

    void checkSpam(String post);

    default void displayModerationPolicy() {
        System.out.println("Policy : Spam content is prohibited.");
    }
}