import java.util.*;

class Product {
    int productId;
    String name;
    double price;

    Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
}
// apply HashMap: orderId → Order


class Order {
    int orderId;
    List<Product> items;
    String status;

    Order(int orderId) {
        this.orderId = orderId;
        this.items = new LinkedList<>(); //for items linkedlist made
        this.status = "Placed";
    }

    void addItem(Product product) {
        items.add(product);
        System.out.println(product.name + " added to order " + orderId);
    }

    void cancelOrder() {
        this.status = "Cancelled";
    }
}

class Customer {
    int customerId;
    String name;
    String phoneNo;
    List<Order> orderHistory;

    Customer(int customerId, String name, String phoneNo) {
        this.customerId = customerId;
        this.name = name;
        this.phoneNo = phoneNo; 
        this.orderHistory = new ArrayList<>();
    }

    void placeOrder(Order order) {
        orderHistory.add(order);
    }
}
// Interface: Payment (Card, UPI, Wallet)
// Polymorphism: Different payment behaviors
//implement paymentfailed exception
interface paymentMethod {
    void pay(double amount) throws PaymentFailedException;
}

class CardPayment implements paymentMethod {
    @Override
    public void pay(double amount) throws PaymentFailedException {
        if (amount > 1000) {
            throw new PaymentFailedException("Card payment failed: Amount exceeds limit.");
        }
        System.out.println("Paid " + amount + " using Card.");
    }
}

class UpiPayment implements paymentMethod  {
    @Override
    public void pay(double amount) throws PaymentFailedException {
        if (amount > 1000) {
            throw new PaymentFailedException("UPI payment failed:Amount exceeds limit.");
        }
        System.out.println("Paid " + amount + " using UPI.");
    }
}

class WalletPayment implements paymentMethod {
    @Override
    public void pay(double amount) throws PaymentFailedException {
        if (amount > 1000) {
            throw new PaymentFailedException("Wallet payment failed:Amount exceeds limit.");
        }
        System.out.println("Paid " +amount+ " using Wallet.");
    }
}

//exception handling paymentfailedexception
class PaymentFailedException extends Exception {
    public PaymentFailedException(String message) {
        super(message);
    }
}

//stack : undo last order (track last added product)
class UndoOrder {
    Stack<Product> productStack = new Stack<>();

    void pushProduct(Product product) {
        productStack.push(product);
    }

    Product popProduct() {
        return productStack.isEmpty() ? null : productStack.pop();
    }
}

// HashMap: orderId → Order
// Central manager to store and retrieve orders by ID
class OrderManager {

    private final Map<Integer, Order> ordersById = new HashMap<>();

    void save(Order order) {
        ordersById.put(order.orderId, order);
    }

    Order get(int orderId) {
        return ordersById.get(orderId);
    }

    void cancel(int orderId) {
        Order o = ordersById.get(orderId);
        if (o != null) {
            o.cancelOrder();
        }
    }

    boolean exists(int orderId) {
        return ordersById.containsKey(orderId);
    }
}

public class ECommerce {
    public static void main(String[] args) {
        // Sample products
        Product product1 = new Product(1, "banana", 80.00);
        Product product2 = new Product(2, "apple", 50.00);
        Product product3 = new Product(3, "orange", 60.00);
        Product product4 = new Product(4, "grapes", 70.00);
        Product product5 = new Product(5, "mango", 90.00);

        // Customer
        Customer customer = new Customer(101, "Arman", "9548784462");

        //ui for user
        System.out.println("Welcome to the E-Commerce Platform, " + customer.name + "!");
        System.out.println("What do you want to order? Here is the list of available products:");
        System.out.println("1. " + product1.name + " for $ " + product1.price + " per kg");
        System.out.println("2. " + product2.name + " for $ " + product2.price + " per kg");
        System.out.println("3. " + product3.name + " for $ " + product3.price + " per kg");
        System.out.println("4. " + product4.name + " for $ " + product4.price + " per kg");
        System.out.println("5. " + product5.name + " for $ " + product5.price + " per kg");
        System.out.println("please use following options");
        System.out.println("1: banana, 2: apple, 3: orange, 4: grapes, 5: mango");
         Order order = new Order(1001);
       Scanner orderScanner = new Scanner(System.in);
      UndoOrder undoOrder = new UndoOrder(); // single stack instance shared in the session
      //ask again if want to add anithing else inside while loop
      while (true) {
          System.out.println("Anything else? 1: banana, 2: apple, 3: orange, 4: grapes, 5: mango (or 0 to finish or 9 to undo last order):");
          int productNumber = orderScanner.nextInt();
          if (productNumber == 0) {
              break;
          }
          if (productNumber == 9) {
              // Undo last added product: remove from order and pop from stack
              Product lastProduct = undoOrder.popProduct();
              if (lastProduct != null) {
                  // remove one occurrence of lastProduct from order.items
                  boolean removed = order.items.remove(lastProduct);
                  if (!removed) {
                      // fallback: remove by name/price match if object identity differs
                      for (Iterator<Product> it = order.items.iterator(); it.hasNext();) {
                          Product p = it.next();
                          if (p.name.equals(lastProduct.name) && p.price == lastProduct.price) {
                              it.remove();
                              removed = true;
                              break;
                          }
                      }
                  }
                  System.out.println(removed ? ("Undid last addition: " + lastProduct.name) : "Nothing to undo.");
              } else {
                  System.out.println("No item to undo.");
              }
              continue;
          }

          switch (productNumber) {
              case 1:
                  order.addItem(product1);
                  undoOrder.pushProduct(product1);
                 continue;
              case 2:
                  order.addItem(product2);
                  undoOrder.pushProduct(product2);
                  continue;
              case 3:
                  order.addItem(product3);
                  undoOrder.pushProduct(product3);
                  continue;
              case 4:
                  order.addItem(product4);
                  undoOrder.pushProduct(product4);
                  continue;
              case 5:
                  order.addItem(product5);
                  undoOrder.pushProduct(product5);
                  continue;
              default:
                  System.out.println("Invalid product number: ");
          }
      }

        System.out.println("press 1 for upi, 2 for card, 3 for wallet to make payment");
        Scanner scanner = new Scanner(System.in);
        int paymentOption = scanner.nextInt();
        paymentMethod paymentMethod;

        switch (paymentOption) {
            case 1:
                paymentMethod = new UpiPayment();
                break;
            case 2:
                paymentMethod = new CardPayment();
                break;
            case 3:
                paymentMethod = new WalletPayment();
                break;
            default:
                System.out.println("Invalid payment option.");
                return;
        }

        //print total cart items
        System.out.println("Your cart items:");
        for (Product item : order.items) {
            System.out.println("- " + item.name + ": " + item.price);
        }

        //print amount deducted from user
        System.out.println("Amount deducted from your account: ");
        //after taking 1,2or 3 input from use get the total price to deduct
        double totalAmount = 0;
        for (Product item : order.items) {
            totalAmount += item.price;
        }
        try {
            paymentMethod.pay(totalAmount);
        } catch (PaymentFailedException e) {
            System.out.println("Payment failed: " + e.getMessage());
            order.cancelOrder();
            // close scanners before exit
            orderScanner.close();
            scanner.close();
            return;
        }

        // Use OrderManager (HashMap: orderId → Order)
        OrderManager orderManager = new OrderManager();
        orderManager.save(order); // store the order by its ID

        // Link order to customer history
        customer.placeOrder(order);

        // close scanners at end
        orderScanner.close();
        scanner.close();

        // Demonstrate retrieval via HashMap
        Order fetched = orderManager.get(1001);
        if (fetched != null) {
            System.out.println("Order " + fetched.orderId + " status: " + fetched.status);
        }
    }
}



//count character freq in string j:1,v:2,
//demostrate encapsulation. using private fields getter and setter
//create custom exception