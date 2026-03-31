
import java.util.*;

public class MatrixOperations {
    // main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // generating a 3x3 matrix
        int[][] matrix = generateMatrix(3, 3);
        System.out.println("Original Matrix :");
        printMatrix(matrix);
        // transposing matrix
        int[][] transposeMatrix = transpose(matrix);
        System.out.println("Transpose Matrix  :");
        printMatrix(transposeMatrix);
        // calculating determinant of 3x3 matrix
        int determinant = determinant3x3(matrix);
        System.out.println("Determinant of 3x3 Matrixx :  " + determinant);
        // calculating inverse if determinant is not zero
        if (determinant != 0) {
            double[][] inverseMatrix = inverse3x3(matrix);
            System.out.println("Inverse of 3x3 Matrix. :");
            printMatrix(inverseMatrix);
        } else {
            System.out.println("Matrix is not invertible");
        }
    }

    public static int[][] generateMatrix(int rowCount, int columnCount) {
        Random random = new Random();
        //  create matrix
        int[][] matrix = new int[rowCount][columnCount];
        for (int rowIndex = 0; rowIndex < rowCount; rowIndex++){
            // fill each column
            for (int columnIndex = 0; columnIndex < columnCount; columnIndex++){
                matrix[rowIndex][columnIndex] = random.nextInt(10); // values between 0-9
            }
        }
        return matrix;
    }
    // method to transpose matrix
    public static int[][] transpose(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];

        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++){

            for (int columnIndex = 0; columnIndex < matrix[0].length; columnIndex++){

                result[columnIndex][rowIndex] = matrix[rowIndex][columnIndex];
            }
        }
        return result;
    }
    // method to calculate determinant of 2x2 matrix
    public static int determinant2x2(int[][] matrix) {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    // method to calculate determinant of 3x3 matrix
    public static int determinant3x3(int[][] matrix) {
        int determinant = matrix[0][0]*(matrix[1][1]*matrix[2][2] - matrix[1][2]*matrix[2][1]) - matrix[0][1]*(matrix[1][0]*matrix[2][2] - matrix[1][2]*matrix[2][0]) +
        matrix[0][2]*(matrix[1][0]*matrix[2][1] - matrix[1][1]*matrix[2][0]);

        return determinant;
    }

    public static double[][] inverse2x2(int[][] matrix) {

        // check if matrix is invertible
        int determinant = determinant2x2(matrix);
        if (determinant == 0) return null;
        //  calculate inverse matrix
        double[][] inverseMatrix = new double[2][2];

        // calculating inverse matrix
        inverseMatrix[0][0] = matrix[1][1] / (double) determinant;
        inverseMatrix[0][1] = -matrix[0][1] / (double) determinant;
        inverseMatrix[1][0] = -matrix[1][0] / (double) determinant;
        inverseMatrix[1][1] = matrix[0][0] / (double) determinant;
        return inverseMatrix;
    }
    // method to calculate inverse of 3x3 matrix
    public static double[][] inverse3x3(int[][] matrix) {
        int determinant = determinant3x3(matrix);
        double[][] inverseMatrix = new double[3][3];
            // calculating first row of inverse matrix
        inverseMatrix[0][0] = ((matrix[1][1]*matrix[2][2] - matrix[1][2]*matrix[2][1]) / (double) determinant);

        inverseMatrix[0][1] = -((matrix[0][1]*matrix[2][2] - matrix[0][2]*matrix[2][1]) / (double) determinant);
        inverseMatrix[0][2] = ((matrix[0][1]*matrix[1][2] - matrix[0][2]*matrix[1][1]) / (double) determinant);
        // calculating second row of inverse matrix
        inverseMatrix[1][0] = -((matrix[1][0]*matrix[2][2] - matrix[1][2]*matrix[2][0]) / (double) determinant);
        inverseMatrix[1][1] = ((matrix[0][0]*matrix[2][2] - matrix[0][2]*matrix[2][0]) / (double) determinant);
        inverseMatrix[1][2] = -((matrix[0][0]*matrix[1][2] - matrix[0][2]*matrix[1][0]) / (double) determinant);
        // calculating last row of inverse matrix
        inverseMatrix[2][0] = ((matrix[1][0]*matrix[2][1] - matrix[1][1]*matrix[2][0]) / (double) determinant);
        inverseMatrix[2][1] = -((matrix[0][0]*matrix[2][1] - matrix[0][1]*matrix[2][0]) / (double) determinant);
        inverseMatrix[2][2] = ((matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0]) / (double) determinant);

        // end of method
        return inverseMatrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row)
                System.out.print(value + " ");
            System.out.println();
        }
    }
    // method to print double matrix
    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row)
                System.out.println( value);
            System.out.println();
        }
    }
}