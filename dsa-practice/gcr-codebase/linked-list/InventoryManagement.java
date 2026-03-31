class InventoryManagement {

    // node class to store item details
    static class Node {

        String itemName;
        int itemId;
        int quantity;
        double price;
        Node next;

        // constructor to assign values
        Node(String itemName, int itemId, int quantity, double price) {
            this.itemName = itemName;
            this.itemId = itemId;
            this.quantity = quantity;
            this.price = price;
            this.next = null;
        }
    }

    // head of linked list
    Node head;

    // adding item at end
    public void addItem(String name, int id, int qty, double price)
     {

        // creating new node
        Node newNode = new Node(name, id, qty, price);

        // if list empty
        if (head == null) 
            {
            head = newNode;
            return;
        }

        // move till last node
        Node temp = head;
        while (temp.next != null) 
            {
            temp = temp.next;
        }

        // link new node
        temp.next = newNode;
    }

    // remove item using item id
    public void removeItem(int id) {

        // if list empty
        if (head == null) {
            System.out.println("inventory empty");
            return;
        }

        // if head need remove
        if (head.itemId == id) {
            head = head.next;
            System.out.println("item removed");
            return;
        }

        Node temp = head;

        // searching node before target
        while (temp.next != null && temp.next.itemId != id) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("item not found");
        } else {
            temp.next = temp.next.next;
            System.out.println("item removed");
        }
    }

    // update quantity using item id
    public void updateQuantity(int id, int newQty) {

        Node temp = head;

        // loop till end
        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                System.out.println("quantity updated");
                return;
            }
            temp = temp.next;
        }

        System.out.println("item not found");
    }

    // search item using id or name
    public void searchItem(int id, String name) {

        Node temp = head;

        while (temp != null) {

            if (temp.itemId == id || temp.itemName.equalsIgnoreCase(name)) {
                System.out.println("item found -> " + temp.itemName);
                return;
            }

            temp = temp.next;
        }

        System.out.println("item not found");
    }

    // calculate total inventory value
    public void calculateTotalValue() {

        double total = 0.0;
        Node temp = head;

        // summing price * quantity
        while (temp != null) {
            total = total + (temp.price * temp.quantity);
            temp = temp.next;
        }

        System.out.println("total inventory value = " + total);
    }

    // display all items
    public void displayItems() {

        Node temp = head;

        // printing items one by one

        while (temp != null) 
            {
            System.out.println(
                temp.itemName + "  | id: " + temp.itemId +
                " | qty: " + temp.quantity +
                " | price: " + temp.price
            );
            temp = temp.next;
        }
    }

    // main method
    public static void main(String[] args) {

        InventoryManagement inventory = new InventoryManagement();

        // adding items
        inventory.addItem("pen", 101, 10, 5.0);

        inventory.addItem("notebook", 102, 5, 50.0) ;

        inventory.addItem("eraser", 103, 20, 2.0);

        // displaying items
        inventory.displayItems();

        // update quantity
        inventory.updateQuantity(102, 8);


        // searching item
        inventory.searchItem(103, "eraser");

        // calculating total value
        inventory.calculateTotalValue();

        // removing item
        inventory.removeItem(101);

        // display again
        inventory.displayItems();
    }
}