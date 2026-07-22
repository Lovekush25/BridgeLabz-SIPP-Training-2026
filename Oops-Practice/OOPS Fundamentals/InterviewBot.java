class InterviewBot {

    String botName;
    String technology;

    InterviewBot(String botName, String technology) {
        this.botName = botName;
        this.technology = technology;
    }

    void conductInterview() {
        System.out.println(botName + " is taking " + technology + " interview.");
    }

    public static void main(String[] args) {

        InterviewBot b1 = new InterviewBot("Bot-A","Java");
        InterviewBot b2 = new InterviewBot("Bot-B","Python");
        InterviewBot b3 = new InterviewBot("Bot-C","C++");

        b1.conductInterview();
        b2.conductInterview();
        b3.conductInterview();
    }
}