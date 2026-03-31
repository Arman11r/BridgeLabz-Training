import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

 class InvalidPizzaOrderException extends Exception {
    public InvalidPizzaOrderException(String msg) {
        super(msg);
    }
}
class PizzaUtil{

    public boolean validateOrderId(String orderId) throws InvalidPizzaOrderException {
        String regex = "^PZ-\\d{3}$";
        boolean isvalid = orderId.matches(regex);
        if(!isvalid){
            throw new InvalidPizzaOrderException("The Order ID "+orderId+" is invalid");
        }
        return isvalid;
    }

    public boolean validatePizzaType(String PizzaType) throws InvalidPizzaOrderException {
        List<String> validatePizzaType = Arrays.asList("Margherita", "Pepperoni", "Veggie", "BBQ Chicken");
        if(!validatePizzaType.contains(PizzaType)){
            throw new InvalidPizzaOrderException("The Pizza Type "+PizzaType+" is invalid");
        }
        return true;

    }

    public boolean validateQuantity(int quantity) throws InvalidPizzaOrderException {
        if(quantity < 1 || quantity > 50){
            throw new InvalidPizzaOrderException("The Quantity "+quantity+" is invalid");
        }
        return true;
    }

    public double calculateFinalBill(String pizzaType,double basePrice,int quantity) throws InvalidPizzaOrderException {
        double toppingpercentage;

        if(basePrice < 100 || basePrice > 1000){
            throw new InvalidPizzaOrderException("The Base Price "+basePrice+" is invalid");
        }
        if(pizzaType.equals("Margherita")){
            toppingpercentage=10;

        }else if(pizzaType.equals("Pepperoni")){
            toppingpercentage=20;
        }else if(pizzaType.equals("Veggie")){
            toppingpercentage=15;
        }else if(pizzaType.equals("BBQ Chicken")){
            toppingpercentage=25;
        }else{
            throw new InvalidPizzaOrderException("The Pizza Type "+pizzaType+" is invalid");
        }
        double basecost = basePrice * quantity;
        double toppingChage = (basecost*toppingpercentage)/100;
        double deliveryFee=100;
        return (basecost+toppingChage+deliveryFee);


    }
}



public class PizzaPulse {

    public static void main(String[] args) {
        PizzaUtil pizzaUtil = new PizzaUtil();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Order Like : <orderID>:<PizzaType>:<BasePrice>:<Quantity>");
        String order =sc.nextLine();
        String[] orderDetails = order.split(":");
        String orderId = orderDetails[0];
        String pizzaType = orderDetails[1];
        double basePrice = Double.parseDouble(orderDetails[2]);
        int quantity = Integer.parseInt(orderDetails[3]);
        try {
            pizzaUtil.validateOrderId(orderId);
            pizzaUtil.validatePizzaType(pizzaType);
            pizzaUtil.validateQuantity(quantity);
            double finalBill = pizzaUtil.calculateFinalBill(pizzaType, basePrice, quantity);
            System.out.println("The Final Bill is : " + finalBill);
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }

    }
    
}
