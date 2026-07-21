public class Circle extends Shape {
    private double radius;
    private final double pi = 3.1415926;

    public void setRadius(int radius){
        this.radius = radius;
    }

    @Override
    public void area(){
        System.out.println("The area of circle is : " + pi * radius * radius);
    }

    @Override
    public void perimeter(){
        System.out.println("The perimeter(circumference) of circle is : " + 2 * pi * radius);
    }
}