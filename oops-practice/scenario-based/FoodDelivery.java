import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
class NoAgentAvailableException extends Exception {
    NoAgentAvailableException(String message) {
        super(message);
    }
}
class Order {
    String customername;
    String item;

    Order(String customername, String item) {
        this.customername = customername;
        this.item = item;
    }

    public String getCustomername() {
        return customername;
    }

    public String getItem() {
        return item;
    }
}

class Agent {
    String name;
    String order;
    boolean isAvailable;

    Agent(String name, String order, boolean isAvailable) {
        this.name = name;
        this.order = order;
        this.isAvailable = isAvailable;
    }

    public String getName() {
        return name;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

public class FoodDelivery {

    public static void main(String[] args) {

        Queue<Order> orderQueue = new LinkedList<>();

        List<Agent> agents = new ArrayList<>();
        agents.add(new Agent("Agent1", "", true));
        agents.add(new Agent("Agent2", "", true));
        agents.add(new Agent("Agent3", "", true));

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Place Order");
            System.out.println("2. Check Active Deliveries");
            System.out.println("3. Exit");

            int choice = sc.nextInt();
            if (choice == 1) {
                int count = 0;

            for (Agent agent : agents) {
                if (agent.isAvailable()) {
                    count++;
                }
            }
            if (count == 0) {
            try {
            throw new NoAgentAvailableException("No agents available. Please wait.");
            } catch (NoAgentAvailableException e) {
            System.out.println(e.getMessage());
            continue;   // don't break program
           }
        }

                System.out.println("Enter your name:");
                String customerName = sc.next();

                System.out.println("Enter item:");
                String item = sc.next();

                orderQueue.add(new Order(customerName, item));
                System.out.println("Order placed!");
                for (Agent agent : agents) {
                    if (agent.isAvailable() && !orderQueue.isEmpty()) {
                        Order order = orderQueue.poll();
                        agent.setAvailable(false);
                        agent.setOrder(order.getItem());
                    }
                }
                
            }

            else if (choice == 2) {

                boolean found = false;

                System.out.println("\nActive Deliveries:");

                for (Agent agent : agents) {
                    if (!agent.isAvailable()) {
                        found = true;
                        System.out.println(agent.getName() +
                                " delivering -> " + agent.getOrder());
                    }
                }

                if (!found)
                    System.out.println("No active deliveries.");

                System.out.println("Do u want to cancel any Order? press 1 for YES / 0 for NO");
                int cancelChoice = sc.nextInt();

                if (cancelChoice == 1) {
                    System.out.println("Enter the item name to cancel the order:");
                    String itemName = sc.next();

                    for (Agent agent : agents) {
                        if (agent.getOrder().equals(itemName) && !agent.isAvailable()) {
                            agent.setAvailable(true);
                            agent.setOrder("");
                            System.out.println("Order cancelled for item: " + itemName);
                            break;
                        }
                    }
                }
            }

            else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            }
        }
    }
}