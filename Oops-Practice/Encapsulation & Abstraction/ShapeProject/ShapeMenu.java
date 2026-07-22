import java.util.*;
public class ShapeMenu extends ShapeMenuAbs {

    shape s;

    @Override
    public void choices(){
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("1.Rectangle \n 2.Triangle \n 3.Circle");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    s = new rectangle();
                    new rectangle().setLength(15);
                    new rectangle().setBreadth(28);
                    s.area();
                    s.perimeter();
                    break;

                case 2:
                    s = new triangle();
                    s.area();
                    s.perimeter();
                    break;

                case 3:
                    s = new circle();
                    s.area();
                    s.perimeter();
                    break;

                default:
                    break;
            }
        }
    }

}