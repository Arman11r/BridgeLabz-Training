public class coursediscount {
    public static void main(String[] args) {
        int fee = 125000; // Original Course Price
        int discountpercentage = 10; // Discount Percentage
        double discountedPrice = fee - (fee * discountpercentage / 100);
        System.out.println("The discounted course price for you is: " + discountedPrice);
    }
}
    