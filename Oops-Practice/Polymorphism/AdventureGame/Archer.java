class Archer extends GameCharacter {

    public Archer(String name) {
        super(name);
    }

    @Override
    public void performAttack() {
        System.out.println(characterName + " shoots Arrow");
    }
}