package DisasterRescue;

public class FoodSupplyTeam extends RescueTeam {

    public FoodSupplyTeam(String id, String loc) {
        super(id, loc);
    }

    public void performDuty() {
        System.out.println(teamId + " distributes food");
    }
}