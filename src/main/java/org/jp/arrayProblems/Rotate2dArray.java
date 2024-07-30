package org.jp.arrayProblems;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

public class Rotate2dArray {

    static Consumer<int[][]> printArray = (arr) -> {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
                System.out.print(" ");
            }
            System.out.println();

        }
    };

    static Function<Integer, int[][]> createMatrix = (size) -> {
        int[][] matrix = new int[size][size];
        int count = 1;
        // putting values in the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = count;
                count++;
            }
        }
        return matrix;
    };

    public static void main(String[] args) {

        // creating n x n matrix
        var matrix = createMatrix.apply(3);

        // find layers to traverse
        int noOfLayers = matrix.length / 2;

        // now we need 4 pointer to the edge of the matrix and traverse no of layers

        int index = 0;
        while (index < noOfLayers) {
            int val1 = matrix[0][0];
            int val2 = matrix[0][2];
            int val3 = matrix[2][2];
            int val4 = matrix[2][0];

            index++;
        }


        printArray.accept(matrix);


    }
}
