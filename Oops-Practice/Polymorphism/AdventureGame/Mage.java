class Mage extends GameCharacter {

    public Mage(String name) {
        super(name);
    }

    @Override
    public void performAttack() {
        System.out.println(characterName + " casts Fireball");
    }
}