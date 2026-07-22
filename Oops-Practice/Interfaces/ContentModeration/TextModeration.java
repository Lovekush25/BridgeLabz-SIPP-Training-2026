interface TextModeration {

    boolean isOffensive(String post);

    default void displayModerationPolicy() {
        System.out.println("No offensive language allowed.");
    }

    static boolean containsRestrictedWords(String post) {

        String text = post.toLowerCase();

        return text.contains("hate") || text.contains("abuse") || text.contains("stupid");
    }
}