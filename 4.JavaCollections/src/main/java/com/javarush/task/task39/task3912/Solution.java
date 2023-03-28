package com.javarush.task.task39.task3912;

/* 
Максимальная площадь
*/

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 1}, {1, 1, 1}, {1, 1, 1}};

        System.out.println(maxSquare(matrix));
        ;
    }

    public static int maxSquare(int[][] matrix) {

        int maxLineLength = 0;

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                if (1 == matrix[i][j]) {
                    boolean isFilled = true;
                    int lineLength = 1;

                    while (isFilled
                            && lineLength + i + 1 <= matrix.length
                            && lineLength + j + 1 <= matrix[0].length) {
                        for (int k = i; isFilled && k < lineLength + i + 1; k++)
                            for (int l = j; isFilled && l < lineLength + j + 1; l++)
                                if (1 != matrix[k][l])
                                    isFilled = false;

                        if (isFilled)
                            ++lineLength;
                    }

                    if (lineLength > maxLineLength)
                        maxLineLength = lineLength;
                }

        return maxLineLength * maxLineLength;
    }
}
