import java.util.*;
class YoungestAndTallestFriend {

    public static void main(String[] args) {
        //scanner
        Scanner sc = new Scanner(System.in);
        // arrays for age and heigh
        int[] age = new int[3 ];
        double[] height = new double[3];
        // taking input
        for (int i = 0; i < 3; i++) {
            age[i] = sc.nextInt();
            height[i] = sc.nextDouble();
        }
        //youngest and tallest variables
        int youngest = age[0];
        double tallest = height[0];
        // finding youngest and tallest
        for (int i = 1; i < 3; i++) {
            //logic
            if (age[i] < youngest) {
                youngest = age[i];
            }
            if (height[i] > tallest) {
                tallest = height[i];
            }
        }
        // printing youngest and tallest output
        System.out.println("Youngest agee is of: " + youngest);
        System.out.println("Tallest height is of: " + tallest);
    }
}