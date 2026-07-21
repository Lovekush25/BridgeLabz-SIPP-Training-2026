package DisasterRescue;

public class FireRescueTeam extends RescueTeam {

    public FireRescueTeam(String id, String loc) {
        super(id, loc);
    }

    public void performDuty() {
        System.out.println(teamId + " controls fire");
    }
}