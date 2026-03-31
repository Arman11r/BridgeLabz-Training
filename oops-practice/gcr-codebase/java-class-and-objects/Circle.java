class Circle {

    // radius of circle
    private double radius;

    // constructor
    Circle(double radius) {
        this.radius = radius;
    }

    // calculating area
    void displayArea() {
        System.out.printf("Area of circle: %.4f%n",
                Math.PI * radius * radius);
    }

    // calculating circumference
    void displayCircumference() {
        System.out.printf("Circumference of circle: %.4f%n",
                2 * Math.PI * radius);
    }
// main method
    public static void main(String[] args) {

        // creating circle object
        Circle circle = new Circle(2.5);

        circle.displayArea();
        circle.displayCircumference();
    }
}