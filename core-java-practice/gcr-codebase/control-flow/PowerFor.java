import java.util.Scanner;

class PowerFor {

    public static void main(String[] args) {
        //scanner created
        Scanner sc = new Scanner(System.in);
        //input variables
        int number, power;
        int result = 1;

        number = sc.nextInt();

        power = sc.nextInt();


        // loop for power belo

        for (int i = 1; i <= power; i++) {
            //in for loop
            result = result * number;
        }
        //output given here
        System.out.println("Result is: " + result);
    }
}