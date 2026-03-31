import java.util.Scanner;

class CoffeeCounter {
    public static void main(String[] args) {
        //scanner created
        Scanner sc = new Scanner(System.in);
        //gst value inside final variable becuase it is constant and cannot be changed
        final double GST_RATE = 0.05; // 5% GST
        //while loop to ask for multiple orders or stop the code running
        while (true) {
            //ask coffe type using 1,2,3 or exit the shop
            System.out.print("\nEnter coffee type Number  \n1.Black Coffee \n2.Latte \n3.Frappe \n4. Exit\nYour choice: ");
            int coffeeType = sc.nextInt();
            //if exit will print cafe closed and break the loop
            if (coffeeType == 4) {
                System.out.println("Cafe closed. Thank you!");
                break;
            }
            //ask for quantityof coffe selected needed
            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine(); // clear buffer
            //starting price = 0
            double price = 0;
            //switch case for coffee type selection here
            switch(coffeeType) {
                case 1:
                    price = 120;
                    break;
                case 2:
                    price = 150;
                    break;
                case 3:
                    price = 180;
                    break;
                default:
                    System.out.println("Invalid coffee type!");
                    continue;
            }
            //calculating bill, gst and total amount here in double for point values
            double bill = price * quantity;
            double gst = bill * GST_RATE;
            double totalAmount = bill + gst;
            //now printing the bill details here with everything ordered and the price :
            System.out.println("\n----- BILL DETAILS -----");
            System.out.println("| Coffee Type : " + coffeeType);
            System.out.println("| Quantity    : " + quantity);
            System.out.println("| Base Bill   : ₹" + bill);
            System.out.println("| GST (5%)    : ₹" + gst);
            System.out.println("| Total Bill  : ₹" + totalAmount);
            System.out.println("---------------------------");
            System.out.println("Thank you for your order!, Visit again");
            System.out.println("---------------------------");
        }

        sc.close();
    }
}