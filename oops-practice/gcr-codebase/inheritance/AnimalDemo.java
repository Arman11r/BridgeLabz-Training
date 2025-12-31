// parent class
class Animal {

    // animal data
    String name;
    int age;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // common method
    void makeSound() {
        System.out.println("animal make sound");
    }
}

// dog class
class Dog extends Animal {

    Dog(String name, int age) {
        super(name, age);
    }

    // overriding sound
    void makeSound() {
        System.out.println("dog barks");
    }
}

// cat class
class Cat extends Animal {

    Cat(String name, int age) {
        super(name, age);
    }

    void makeSound() {
        System.out.println("cat meows");
    }
}

// bird class
class Bird extends Animal {

    Bird(String name, int age) {
        super(name, age);
    }

    void makeSound() {
        System.out.println("bird chirps");
    }
}

public class AnimalDemo {
    public static void main(String[] args) {

        Animal a1 = new Dog("rockyy", 3);
        Animal a2 = new Cat("kitty", 2);

        Animal a3 = new Bird("hawkeye", 1);

        a1.makeSound();
        a2.makeSound();

        a3.makeSound();
    }
}