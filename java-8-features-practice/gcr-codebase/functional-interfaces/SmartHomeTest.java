
interface SmartDevice {
    void turnOn();
    void turnOff();
}


class Light implements SmartDevice {

    public void turnOn() {
        System.out.println("ON");
    }

    public void turnOff() {
        System.out.println("OFF");
    }
}


class AC implements SmartDevice {

    public void turnOn() {
        System.out.println("AC started ");
    }

    public void turnOff() {
        System.out.println("AC stopped");
    }
}


class TV implements SmartDevice {

    public void turnOn() {
        System.out.println("ON");
    }

    public void turnOff() {
        System.out.println("OFF");
    }
}


public class SmartHomeTest {

    public static void main(String[] args) {

        SmartDevice light = new Light();
        SmartDevice ac = new AC();
        SmartDevice tv = new TV();

        light.turnOn();
        ac.turnOn();
        tv.turnOn();
    }
}