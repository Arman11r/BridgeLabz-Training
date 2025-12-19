import java.util.Scanner;

class PowerWhile {

    public static void main(String[] args) {

        //scanner created/
        Scanner sc = new Scanner(System.in);
        // input variables created
        int number, power;
        int result = 1 ;
        int counter =0;
        //taken input
        number =  sc.nextInt();
        power = sc.nextInt();

        // loop till less than power
        while (counter < power) {
            result = result *  number;
            counter++;
        }
        // output here given
        System.out.println("Result is. : " + result);
    }
}