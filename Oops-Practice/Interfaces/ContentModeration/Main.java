public class Main {

    public static void main(String[] args) {

        String[] posts = {
                "I love Java Programming",
                "Buy now and get 50% discount",
                "You are stupid",
                "Click here to win iPhone",
                "Have a great day"
        };

        ContentModerator moderator = new ContentModerator();

        moderator.displayModerationPolicy();

        System.out.println();

        for (String post : posts) {

            System.out.println("Post : " + post);

            if (moderator.isSpam(post)) {
                System.out.println("Status : Spam");
            }
            else if (moderator.isOffensive(post)) {
                System.out.println("Status : Offensive");
            }
            else {
                System.out.println("Status : Valid");
            }

            System.out.println();
        }
    }
}