import java.util.*;

class FactorsWhile {

    public static void main(String[] args)  {

        // scanner object created
        Scanner sc = new Scanner(System.in);

        int number;


        int counter = 1;

        // asking input heree


        System.out.print("Enter  number. : ");
     number = sc.nextInt();

        // checking positive values
        if (number > 0) {

            // while loop here
            while (counter < number) {

                if (number % counter == 0) {


                    System.out.println(counter);
                }
              counter++;
            }

        } else {
            //worng
            System.out.println("invalid number. : "  );
        }
    }
}