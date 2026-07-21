public class Main {

    public static void main(String[] args) {

        String[] posts = {

                "Welcome to our community.",
                "Buy now and get 50 percent discount.",
                "I hate this game.",
                "Click here to win a free phone.",
                "Java is an amazing programming language.",
                "You are stupid.",
                "Have a wonderful day."

        };

        ContentModerator moderator = new ContentModerator();

        moderator.displayModerationPolicy();

        System.out.println();

        moderator.moderatePosts(posts);

    }
}