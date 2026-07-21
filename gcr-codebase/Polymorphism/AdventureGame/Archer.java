package AdventureGame;

public class Archer extends GameCharacter {

    public Archer(String characterName) {
        super(characterName);
    }

    public void performAttack() {
        System.out.println(characterName + " shoots arrow");
    }
}