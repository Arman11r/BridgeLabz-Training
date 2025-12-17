public static void main(String[] args) {

    Scanner input = new Scanner(System.in); // renamed from sc

    // Getting radius first
    System.out.print("Enter the radius of the cylinder: ");
    double r = input.nextDouble();

    // Now getting height
    System.out.print("Enter the height of the cylinder: ");
    double h = input.nextDouble();

    // Using the standard formula:
    // Volume = PI * r * r * h
    // Could use Math.pow(), but this feels simpler
    double vol = Math.PI * r * r * h;

    // Printing the result
    System.out.println("Volume of the cylinder is: " + vol);

  }
