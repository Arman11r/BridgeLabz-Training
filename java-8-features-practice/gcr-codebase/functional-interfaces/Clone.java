class PrototypeModel implements Cloneable {

    int value;

    PrototypeModel(int v) {
        value = v;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


public class Clone {

    public static void main(String[] args) throws Exception {

        PrototypeModel obj1 = new PrototypeModel(50);

        PrototypeModel obj2 = (PrototypeModel) obj1.clone();

        System.out.println("Original: " + obj1.value);
        System.out.println("Cloned: " + obj2.value);
    }
}