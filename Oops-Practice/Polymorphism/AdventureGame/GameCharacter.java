class GameCharacter {

    protected String characterName;

    public GameCharacter(String characterName) {
        this.characterName = characterName;
    }

    public void performAttack() {
        System.out.println("Attack");
    }
}