public class Main {

    public static void startBattle(
            GameCharacter[] characters) {

        int warriors = 0;
        int mages = 0;
        int archers = 0;

        for (GameCharacter c : characters) {

            c.performAttack();

            if (c instanceof Warrior)
                warriors++;

            else if (c instanceof Mage)
                mages++;

            else if (c instanceof Archer)
                archers++;
        }

        System.out.println();

        System.out.println("Warriors : "
                + warriors);

        System.out.println("Mages : "
                + mages);

        System.out.println("Archers : "
                + archers);
    }

    public static void main(String[] args) {

        GameCharacter[] players = {

                new Warrior("Thor"),

                new Mage("Merlin"),

                new Archer("Robin"),

                new Warrior("Leon")
        };

        startBattle(players);
    }
}