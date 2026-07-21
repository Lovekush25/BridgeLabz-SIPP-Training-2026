public interface TextModeration {

    void checkOffensiveContent(String post);

    default void displayModerationPolicy() {
        System.out.println("Policy : Offensive language is not allowed.");
    }

    static boolean containsRestrictedWords(String post) {

        String text = post.toLowerCase();

        return text.contains("hate")
                || text.contains("abuse")
                || text.contains("stupid");
    }
}