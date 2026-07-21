package DisasterRescue;

public class Main {

    public static void main(String[] args) {
        RescueTeam[] t = new RescueTeam[3];

        t[0] = new MedicalTeam("M1", "A");
        t[1] = new FireRescueTeam("F1", "A");
        t[2] = new FoodSupplyTeam("S1", "B");

        int m = 0, f = 0, s = 0;

        for (RescueTeam x : t) {
            x.performDuty();

            if (x instanceof MedicalTeam) m++;
            else if (x instanceof FireRescueTeam) f++;
            else if (x instanceof FoodSupplyTeam) s++;
        }

        System.out.println(m);
        System.out.println(f);
        System.out.println(s);
    }
}