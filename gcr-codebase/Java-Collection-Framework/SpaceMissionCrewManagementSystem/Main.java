public class Astronaut {

    private String astronautId;
    private String name;
    private String specialization;

    public Astronaut(String astronautId, String name, String specialization) {
        this.astronautId = astronautId;
        this.name = name;
        this.specialization = specialization;
    }

    public String getAstronautId() {
        return astronautId;
    }

    @Override
    public String toString() {
        return "Astronaut ID : " + astronautId +
                "\nName : " + name +
                "\nSpecialization : " + specialization;
    }
}