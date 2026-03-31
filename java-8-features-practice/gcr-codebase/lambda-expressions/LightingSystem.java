import java.util.*;

interface LightAction {
    void turnOn();
}

public class LightingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // lambda.
        LightAction motion = () -> System.out.println("light turn on 100%");
        LightAction night  = () -> System.out.println("Lights dimmed to 30%");
        LightAction voice  = () -> System.out.println("Lights color changed through voice command");

        System.out.println("Chose one options -> 1.Motion  2.Night  3.Voice");
        int choice = sc.nextInt();

        LightAction action = null;

        if (choice == 1) action = motion;
        else if (choice == 2) action = night;
        else action = voice;

        action.turnOn();
        sc.close();
    }
}