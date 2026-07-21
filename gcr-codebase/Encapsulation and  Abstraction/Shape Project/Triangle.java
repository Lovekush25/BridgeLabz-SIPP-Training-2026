public class Triangle extends Shape {
    private double base;
    private double height;
    private double a;
    private double b;

    Triangle t;
    public void setBase(int base){
        this.base = base;
    }
    public void setHeight(int height){
        this.height = height;
    }

    @Override
    public void area(){
        t = new Triangle();
        System.out.println("The area of triangle is : " + 0.5 * t.base * t.height);
    }

    @Override
    public void perimeter(){
        t = new Triangle();
        System.out.println("The perimter of triangle is : " + t.a + t.b + t.base);
    }
}