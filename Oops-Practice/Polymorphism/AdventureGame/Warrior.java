class Warrior extends GameCharacter {

    public Warrior(String name) {
        super(name);
    }

    @Override
    public void performAttack() {
        System.out.println(characterName + " attacks with Sword");
    }
}