package AdventureGame;

public class Warrior extends GameCharacter {

    public Warrior(String characterName) {
        super(characterName);
    }

    public void performAttack() {
        System.out.println(characterName + " attacks with sword");
    }
}