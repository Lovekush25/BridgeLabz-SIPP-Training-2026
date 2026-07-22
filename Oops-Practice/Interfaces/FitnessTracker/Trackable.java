interface Trackable {
    void logActivity();
    default void resetData() {
        System.out.println("Activity data has been reset.");
    }
}