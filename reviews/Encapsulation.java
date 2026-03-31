//demostrate encapsulation. using private fields getter and setter
class Person {
    // private fields
    private String sirname;
    private int age;

    // getter to get sirname
    public String getsirName() {
        return sirname ;
    }

    // setter to sewt name
    public void setsirName(String name) {
        this.sirname = name;
    }

    // getter to get age
    public int getAge() {
        return age;
    }

    // setter to set age
    public void setAge(int age) {
       
            this.age = age;
        
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.setsirName("Arman");
        person.setAge(23);

        System.out.println("Name: " + person.getsirName());
        System.out.println("Age: " + person.getAge());
    }
}