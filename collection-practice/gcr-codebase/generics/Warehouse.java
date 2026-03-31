import java.util.*;

// base class for all items
abstract class WarehouseItem {
    String name;

    WarehouseItem(String name) {
        this.name = name;
    }

    void showItem() {
        System.out.println("item:" + name);
    }
}

// different item types
class Electronics extends WarehouseItem 
{
    Electronics(String name) 
    {
        super(name);
    }
}

class Groceries extends WarehouseItem {
    Groceries(String name) {
        super(name);
    }
}

class Furniture extends WarehouseItem {
    Furniture(String name) {
        super(name);
    }
}

// generic storage class
class Storage<T extends WarehouseItem> {

    List<T> items = new ArrayList<>();

    void addItem(T item) {
        items.add(item);
    }

    List<T> getItems() {
        return items;
    }
}

public class Warehouse {

    // wildcard method to show any item
    static void displayAll(List<? extends WarehouseItem> list) {
            for (WarehouseItem i : list) {

            i.showItem();
        }
    }

    public static void main(String[] args) {

        Storage<Electronics> eStore = new Storage<>();
        eStore.addItem(new Electronics("Laptop "));
        eStore.addItem(new Electronics(" Mobile"));

        Storage<Groceries> gStore = new Storage<>();
        gStore.addItem(new Groceries("Rice.  "));

        displayAll(eStore.getItems());


        displayAll(gStore.getItems());
    }
}