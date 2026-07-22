public class NullPointerDemo {
    public static void generateException() {
        String text = null;
        // This will throw NullPointerException
        int len = text.length();
        System.out.println("Length: " + len); // unreachable
    }

    public static void handleException() {
        String text = null;
        try {
            System.out.println("Trying to access length...");
            System.out.println(text.length());
        } catch (NullPointerException ex) {
            System.out.println("Caught NullPointerException: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("Calling generator (will throw and terminate if uncaught). We'll catch it here to continue.");
        try {
            generateException();
        } catch (NullPointerException ex) {
            System.out.println("Generator threw: " + ex.getClass().getSimpleName());
        }

        System.out.println("Now calling handler which manages the exception internally:");
        handleException();
    }
}