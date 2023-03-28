package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(1234);
    }

    /*public void createExpression(int number)
    {
        int number1 = number;

        int[] numbers = new int[]{1, 3, 9, 27, 81, 243, 729, 2187};

        StringBuilder stringBuilder = new StringBuilder();

        int index =  numbers.length - 1;

        while (0 != number1)
        {
            for (int i = 0; i < index + 1; i++)
                if (numbers[i] >= Math.abs(number1))
                {
                    index = i;
                    break;
                }

            String sign = "";

            if (number1 > 0)
            {
                sign = "+";
                number1 -= numbers[index];
            } else
            {
                sign = "-";
                number1 += numbers[index];
            }
            stringBuilder.insert(0, sign + " " + numbers[index] + " ");
            --index;
        }
        System.out.println(number + " = " + stringBuilder.toString().trim());
    }*/

    public void createExpression(int number) {
        String[] allowedNumbers = {"1", "3", "9", "27", "81", "243", "729", "2187"};
        StringBuilder sb = new StringBuilder(number + " = ");
        String inTernarySymmetric = convertToTernarySymmetric(number);
        for (int i = 0; i < inTernarySymmetric.length(); i++) {
            if (inTernarySymmetric.charAt(i) != '0') {
                sb.append(inTernarySymmetric.charAt(i));
                sb.append(" ");
                sb.append(allowedNumbers[i]);
                sb.append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }

    private String convertToTernarySymmetric(int number) {
        StringBuilder sb = new StringBuilder();
        while (number >= 2) {
            if (number % 3 == 0) {
                sb.append("0");
                number /= 3;
            } else if (number % 3 == 1) {
                sb.append("+");
                number /= 3;
            } else if (number % 3 == 2) {
                sb.append("-");
                number = (number / 3) + 1;
            }
        }
        if (number == 1) {
            sb.append("+");
        }
        return sb.toString();
    }
}