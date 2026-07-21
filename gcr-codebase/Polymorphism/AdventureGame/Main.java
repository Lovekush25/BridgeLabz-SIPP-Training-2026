package AdventureGame;

public class Main {

    public static void startBattle(GameCharacter[] chars) {
        int w = 0, m = 0, a = 0;

        for (GameCharacter c : chars) {
            c.performAttack();

            if (c instanceof Warrior) w++;
            else if (c instanceof Mage) m++;
            else if (c instanceof Archer) a++;
        }

        System.out.println("Warriors: " + w);
        System.out.println("Mages: " + m);
        System.out.println("Archers: " + a);
    }

    public static void main(String[] args) {
        GameCharacter[] chars = new GameCharacter[3];

        chars[0] = new Warrior("A");
        chars[1] = new Mage("B");
        chars[2] = new Archer("C");

        startBattle(chars);
    }
}