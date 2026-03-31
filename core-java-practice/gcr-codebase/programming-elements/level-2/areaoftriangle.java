// public Write a program that takes the base and height to find area of a triangle in square inches and square centimeters 
// Hint => Area of a Triangle is ½ * base * height
// I/P => base, height user input
// O/P => Your Height in cm is ___ while in feet is ___ and inches is ___
//first comment then on next line code

import java.util.Scanner;
public class areaoftriangle {
    public static void main(String[] args) {
        // Scanner object for user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the base of the triangle (in inches): ");
        double base = sc.nextDouble();
        System.out.print("Enter the height of the triangle (in inches): ");
        double height = sc.nextDouble();

        // Calculate area
        double areaInSquareInches = 0.5 * base * height;
        double areaInSquareCm = areaInSquareInches * 6.4516;

        // Output results,
        System.out.println("The area of the triangle is " + areaInSquareInches + " square inches and " + areaInSquareCm + " square centimeters.");
    }
}