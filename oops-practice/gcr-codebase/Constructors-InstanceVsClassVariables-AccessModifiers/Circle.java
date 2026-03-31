class Circle {

    // radius of circle
    double radius;

    // default constructor
    Circle() {
        // calling parameter constructor
        this(1.0);
    }

    // parameterized constructor
    Circle(double radius) {
        // assigning radius
        this.radius = radius;
    }

    // display radius
    void display() {
        System.out.println("Radius is " + radius);
    }

    public static void main(String[] args) {

        // circle with default radius
        Circle c1 = new Circle();

        // circle with given radius
        Circle c2 = new Circle(5);

        // printing values
        c1.display();
        c2.display();
    }
}