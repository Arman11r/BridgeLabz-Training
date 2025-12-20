import java.util.Scanner;

class NumberArrayCheck {

    public static void main(String[] args) {
        //scanner created
        Scanner sc = new Scanner(System.in);
        // array to store 5 numbers 
        int[] numbers = new int[5];

        // taking inputs to enter 5 numbers in array
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number" + (i + 1) + " :  ") ;
            numbers[i] = sc.nextInt();
        }

        // checking each number heree
        for (int i = 0; i < numbers.length; i++) 
            {

            if (numbers[i] > 0) 
                {
                    //for odd even here

                if (numbers[i] % 2 == 0) {
                    System.out.println(numbers[i] + " is positive even ");
                } else {
                    System.out.println(numbers[i] + " is positive  odd");
                }

            } 
            else if (numbers[i] < 0) {
                System.out.println(numbers[i] + " is negative");
            } 
            else {
                System.out.println("zero");
            }
        }

        // comparing first and last to check which is greather here
        if (numbers[0] == numbers[4]) {
            System.out.println("first and last are equall");

        } 
        else if (numbers[0] > numbers[4]) {

            System.out.println("first is  greater");
        } 
        else {


            System.out.println("last is greater ");
        }
// closing scanner

        sc.close();
    }
}