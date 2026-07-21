package AdventureGame;

public class Mage extends GameCharacter {

    public Mage(String characterName) {
        super(characterName);
    }

    public void performAttack() {
        System.out.println(characterName + " casts fireball");
    }
}