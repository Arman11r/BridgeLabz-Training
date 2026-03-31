import java.util.Scanner;
public class coursediscountuserinput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //Scanner object for user input
        System.out.print("Enter the original course fee: "); //User prompt
        int fee = sc.nextInt();     // original course fee from user
        System.out.print("Enter the discount percentage: ");
        int discountpercentage = sc.nextInt();  // discount percentage from user taken  
        double discountedPrice = fee - (fee * discountpercentage / 100); // discounted price calculat
        System.out.println("The discounted course price for you is: " + discountedPrice);   // print results
        
    }
}
