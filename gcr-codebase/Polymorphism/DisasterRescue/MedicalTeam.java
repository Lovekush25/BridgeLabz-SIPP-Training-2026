package DisasterRescue;

public class MedicalTeam extends RescueTeam {

    public MedicalTeam(String id, String loc) {
        super(id, loc);
    }

    public void performDuty() {
        System.out.println(teamId + " gives medical help");
    }
}