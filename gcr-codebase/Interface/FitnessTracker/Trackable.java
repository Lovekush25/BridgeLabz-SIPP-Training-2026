public interface Trackable {

    void logActivity();

    default void resetData() {
        System.out.println("Fitness data has been reset.");
    }
}