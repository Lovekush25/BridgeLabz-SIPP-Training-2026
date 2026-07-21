public class Rectangle extends Shape {

    private int length;
    private int breadth;

    Rectangle r;

    public void setLength(int length){
        this.length = length;
    }
    public void setBreadth(int breadth){
        this.breadth = breadth;
    }

    @Override
    public void area(){
        r = new Rectangle();
        System.out.println("Area of rectangel is : " + r.length * r.breadth);
    }

    @Override
    public void perimeter(){
        r = new Rectangle();
        System.out.println("The perimeter of rectangle is : " + 2 * (r.length + r.breadth));
    }
}