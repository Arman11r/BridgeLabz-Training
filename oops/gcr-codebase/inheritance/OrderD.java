// base order class
class Order {

    int orderId;
    String orderDate;

    Order(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    String getOrderStatus() {
        return "order placed";
    }
}

// shipped order
class ShippedOrder extends Order {

    String trackingNumber;

    ShippedOrder(int orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);

        this.trackingNumber = trackingNumber;
    }

    String getOrderStatus() {
        return "order shipped!!";
    }
}

// delivered order
class DeliveredOrder extends ShippedOrder {

    String deliveryDate;

    DeliveredOrder(int orderId, String orderDate,

                   String trackingNumber, String deliveryDate) 
                   {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    String getOrderStatus() {
        return "order delivered";
    }
}

public class OrderD {
    public static void main(String[] args) {

        Order o1 =
                new DeliveredOrder(101, "10=09-2025",
                        "TRK12345", "15-09-2025");

        System.out.println(o1.getOrderStatus());
    }
}