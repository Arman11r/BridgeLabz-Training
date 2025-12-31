
class CartItem {

    // item details
    private String itemName;
    private double price;
    private int quantity;

    // constructor
    CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // adding item
    void addItem(int qty) {
        quantity = quantity + qty;
        System.out.println("Added " + qty + " items");
    }

    // removing item
    void removeItem(int qty) {

        if (qty <= quantity) {
            quantity = quantity - qty;
            System.out.println("Removed " + qty + " items");
        } else {
            System.out.println("not enough items");
        }
    }

    // total cost
    double totalCost() {
        return price * quantity;
    }

    // display cart
    void displayItem() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }

    public static void main(String[] args) {
// creating cart item object
        CartItem item =
                new CartItem("Laptop", 999.99, 1);
// displaying item details
        item.displayItem();
        item.addItem(2);
        item.removeItem(1);
        // displaying total cost
        System.out.println("Total cost: " + item.totalCost());
    }
}