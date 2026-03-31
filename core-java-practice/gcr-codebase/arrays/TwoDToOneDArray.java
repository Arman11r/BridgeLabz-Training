import java.util.Scanner;

class TwoDToOneDArray {

    public static void main(String[] args) {
        //scanner
        Scanner sc = new Scanner(System.in);
//input rows and cols/
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        // declaring 2d and 1d array both ere
        int[][] matrix = new int[rows][cols];
        int[] array = new int[rows * cols];
        //index for 1d array 
        int index = 0;

        // taking matrix input
        for (int i = 0; i < rows; i++) {


            for (int j = 0; j < cols; j++) {
                
                //2d array vakue input
                matrix[i][j] = sc.nextInt();
                
            }
        }

        // copying to 1d for conversion here
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                array[index++] = matrix[i][j];


            }
        }

        // printing 1d array
        for (int i = 0; i < array.length; i++) {

            System.out.print(array[i] + " ");
            
        }
    }
}