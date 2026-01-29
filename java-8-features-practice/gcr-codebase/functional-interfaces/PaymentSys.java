interface PaymentProcessor {

    void pay(double amount);

    default void refund(double amount) {
        System.out.println("Refund of ₹" + amount + " processed (basic refund)");
    }
}



class UpiPayment implements PaymentProcessor {

    public void pay(double amount) {
        System.out.println("Paid using UPI: ₹" + amount);
    }
}


//
class CardPayment implements PaymentProcessor {

    public void pay(double amount) {
        System.out.println("Paid using Card: ₹" + amount);
    }
}


public class PaymentSys {

    public static void main(String[] args) {

        PaymentProcessor p1 = new UpiPayment();
        p1.pay(500);
        p1.refund(200); 

        PaymentProcessor p2 = new CardPayment();
        p2.pay(1000);
        p2.refund(300);
    }
}