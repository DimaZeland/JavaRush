package com.javarush.task.task39.task3909;

/* 
Одно изменение
*/

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(isOneEditAway("abacba", "abaccba"));
    }

    public static boolean isOneEditAway(String first, String second) {
        int lengthDifference = first.length() - second.length();

        if (lengthDifference == 0) {
            return checkReplacement(first, second);
        } else if (lengthDifference == 1) {
            return checkInsertion(first, second);
        } else if (lengthDifference == -1) {
            return checkInsertion(second, first);
        } else {
            return false;
        }
    }

    private static boolean checkReplacement(String first, String second) {
        boolean foundDifference = false;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                if (foundDifference) {
                    return false;
                } else {
                    foundDifference = true;
                }
            }
        }
        return true;
    }

    private static boolean checkInsertion(String first, String second) {
        int i = 0;
        int j = 0;

        while (j < second.length() && i < first.length()) {
            if (first.charAt(i) != second.charAt(j)) {
                if (i != j) {
                    return false;
                }
                i++;
            } else {
                i++;
                j++;
            }
        }
        return true;
    }

    /*public static boolean isOneEditAway(String first, String second)
    {

        boolean stringsLengthsSame = first.length() == second.length();

        int changeCount = 0;

        for (int i = 0; i < first.length(); i++)
        {
            Character char1 = first.charAt(i);
            Character char2 = second.charAt(i);

            if (char1.equals(char2))
                continue;
            else
            {
                if (++changeCount > 1)
                    return false;

                if (stringsLengthsSame)
                    second = first.substring(0, i + 1) + second.substring(i + 1, second.length());
                else
                {
                    if (first.length() > second.length())
                        second = first.substring(0, i + 1) + second.substring(i, second.length());
                    else
                        first = second.substring(0, i + 1) + first.substring(i, first.length());
                }
            }
        }
        return true;
    }*/
}
