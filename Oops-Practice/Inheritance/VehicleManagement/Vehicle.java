class Vehicle {
    protected String model;
    protected int maxSpeed;

    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public void display() {
        System.out.println("Model : " + model);
        System.out.println("Max Speed : " + maxSpeed);
    }
}