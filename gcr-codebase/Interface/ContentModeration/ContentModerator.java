public class ContentModerator implements TextModeration, SpamDetection {

    @Override
    public void checkOffensiveContent(String post) {

        if (TextModeration.containsRestrictedWords(post)) {
            System.out.println("Offensive Post : " + post);
        }
    }

    @Override
    public void checkSpam(String post) {

        String text = post.toLowerCase();

        if (text.contains("buy now")
                || text.contains("click here")
                || text.contains("free money")) {

            System.out.println("Spam Post : " + post);
        }
    }

    @Override
    public void displayModerationPolicy() {

        TextModeration.super.displayModerationPolicy();
        SpamDetection.super.displayModerationPolicy();
    }

    public void moderatePosts(String[] posts) {

        for (String post : posts) {

            String text = post.toLowerCase();

            boolean spam = text.contains("buy now")
                    || text.contains("click here")
                    || text.contains("free money");

            boolean offensive = TextModeration.containsRestrictedWords(post);

            if (spam) {

                System.out.println();
                checkSpam(post);

            } else if (offensive) {

                System.out.println();
                checkOffensiveContent(post);

            } else {

                System.out.println();
                System.out.println("Valid Post : " + post);

            }

        }

    }
}