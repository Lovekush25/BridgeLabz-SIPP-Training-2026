class Calculator{
    int a;
    int b;
    int c;
    public Calculator(int a,int b,int c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
    public static void main(String[] args) {
        public void add(int a,int b) {
            c = a + b;
        }
    }
    public static subtract(int a,int b){
        c=a-b;
        System.out.print(c);
    }
    public static divide(int a,int b){
        c=a/b;
        System.out.print(c);
    }
    public void multiply(int a,int b){
        c=a*b;
        System.out.print(c);
    }
    System.out.println("Enter your choice from menu");
    System.out.println("1.Add\n2.Subtract\n3.Divide\n4.Multiply");
    Scanner sc= new Scanner(System.in);
    Calculator calc = new Calculator();
    int choice=sc.nextInt();
    switch (choice){
        case 1:calc.add(10,20);
        break;
        case 2:calc.subtract(20,10);
        break;
        case 3:calc.divide(10,5);
        break;
        case 4:calc.multiply(5,4);
        break;
        default:System.out.print("Wrong Choise");
        break;
    }
}