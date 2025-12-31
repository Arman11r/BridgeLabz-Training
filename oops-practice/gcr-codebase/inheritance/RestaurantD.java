// worker interface
interface Worker {

    // work method
    void performDuties();
}

// person class
class Person {

    String name;
    int id;

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

// chef class
class Chef extends Person implements Worker {

    Chef(String name, int id) {
        super(name, id);
    }

    public void performDuties() {
        System.out.println("chef cooking food.   ");
    }
}

// waiter class
class Waiter extends Person implements Worker {

    Waiter(String name, int id) {
        super(name, id);
    }

    public void performDuties() {
        System.out.println("waiter serving food. ");
    }
}

public class RestaurantD {
    public static void main(String[] args) {

        Worker w1 = new Chef("Arman", 1);
        Worker w2 = new Waiter("Ayushi", 2);

        w1.performDuties();
        w2.performDuties();
    }
}