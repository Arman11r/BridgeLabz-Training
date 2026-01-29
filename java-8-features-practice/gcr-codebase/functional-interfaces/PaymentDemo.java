interface Payment {
    void pay(double amount);
}

class UPI implements Payment {

    public void pay(double amount) {
        System.out.println("Paid " + amount + " using UPI");
    }
}

class CreditCard implements Payment {

    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

public class PaymentDemo {

    public static void main(String[] args) {

        Payment p = new UPI();
        p.pay(500);
    }
}