public static void main(String[] args) {

    Scanner input = new Scanner(System.in); // using a friendlier variable name

    // Taking principal amount
    System.out.print("Enter principal amount: ");
    double p = input.nextDouble();   // short variable name, common in practice

    // Taking rate of interest
    System.out.print("Enter rate of interest: ");
    double r = input.nextDouble();

    // Taking time period in years
    System.out.print("Enter time (in years): ");
    double t = input.nextDouble();

    // Simple Interest formula
    double si = (p * r * t) / 100;

    // Displaying result
    System.out.println("Simple Interest is: " + si);

   
}
