class ContentModerator implements TextModeration, SpamDetection {

    @Override
    public boolean isOffensive(String post) {
        return TextModeration.containsRestrictedWords(post);
    }

    @Override
    public boolean isSpam(String post) {

        String text = post.toLowerCase();

        return text.contains("buy now") || text.contains("click here");
    }

    @Override
    public void displayModerationPolicy() {
        TextModeration.super.displayModerationPolicy();
        SpamDetection.super.displayModerationPolicy();
    }
}