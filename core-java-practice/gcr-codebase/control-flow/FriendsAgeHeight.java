import java.util.Scanner;

class FriendsAgeHeight {

    public static void main(String[] args) {

        // scanner object
        Scanner sc = new Scanner(System.in);

        // age variables
         int amarAge, akbarAge, anthonyAge;

        // height variables
        double amarHeight , akbarHeight , anthonyHeight;

        // taking age input
        amarAge = sc.nextInt();
        akbarAge = sc.nextInt();
        anthonyAge = sc.nextInt();

        // taking height input
        amarHeight = sc.nextDouble();


        akbarHeight = sc.nextDouble();

        anthonyHeight = sc.nextDouble();


        // finding youngest
        int youngestAge = Math.min(amarAge, Math.min(akbarAge ,  anthonyAge));

        // finding tallest
        double tallestHeight = Math.max(amarHeight, Math.max(akbarHeight, anthonyHeight));

        // printing result
        System.out.println("Youngest age is. : " + youngestAge);


        System.out.println("Tallest height iss : " + tallestHeight);
    }

}