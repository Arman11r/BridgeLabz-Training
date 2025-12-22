

import java.util.*;

public class HandShakeCalculator {
    // method to calculate handshakes
    public static int calculateHandshakes(int studentCount) {
        return (studentCount * (studentCount - 1)) / 2;
    }
    // main method
    public static void main(String[] args) {
        // create scanner object//
        Scanner sc = new Scanner(System.in);
        // get number of students
        int students = sc.nextInt();
        // calculate total handshakes
        int totalHandshakes = calculateHandshakes(students);
        // print total handshakes
        System.out.println(totalHandshakes);
    }
}