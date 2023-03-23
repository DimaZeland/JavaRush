package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/* 
Почитать в инете про медиану выборки
*/

public class Solution {

    public static void main(String[] args) {
       /* Integer[] array = {0, 1, 2, 4, 5, 6};

        for (Integer i: sort(array))
            System.out.print(i + ", ");*/
    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);

        final int size = array.length;

        int medianValue = size % 2 == 1 ? array[size / 2] : (array[size / 2] + array[size / 2 - 1]) / 2;

        Comparator<Integer> medianComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 13 17 5
                int o1Diff = Math.abs(medianValue - o1); // 4
                int o2Diff = Math.abs(medianValue - o2); //8
                return o1Diff - o2Diff;
            }
        };

        Arrays.sort(array, medianComparator);

        return array;
    }
}
