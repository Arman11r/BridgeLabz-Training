class Person {

    // storing name
    String name;

    // storing age
    int age;

    // normal constructor
    Person(String name, int age) {
        // assigning values
        this.name = name;
        this.age = age;
    }

    // copy constructor
    Person(Person p) {
        // copying values from another object
        this.name = p.name;
        this.age = p.age;
    }

    // displaying person data
    void display() {
        System.out.println(name + " age " + age);
    }

    public static void main(String[] args) {

        // creating first person
        Person p1 = new Person("Arman", 20);

        // cloning person using copy constructor
        Person p2 = new Person(p1);

        // displaying both
        p1.display();
        p2.display();
    }
}