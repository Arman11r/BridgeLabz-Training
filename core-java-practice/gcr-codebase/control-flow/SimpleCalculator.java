import java.util.Scanner;

class SimpleCalculator {

    public static void main(String[] args) {
        //scannr created heree
        Scanner sc = new Scanner(System.in);
        //variable declaration
        double first;
        double second;
        String op;
        //input take
        first = sc.nextDouble();
        second = sc.nextDouble();
        op = sc.next();

        // switch case for operator
        switch (op) {

            case "+":
                System.out.println(first  + second);
                break;

            case "-":
                System.out.println(first -  second);
                break;

            case "*":

                System.out.println(first *  second);
                break;

            case "/":

                System.out.println(first / second);
                break;

            default:

                System.out.println("Invalid Operator");
        }
         

      sc.close(); //scanner close 
  }
 
}