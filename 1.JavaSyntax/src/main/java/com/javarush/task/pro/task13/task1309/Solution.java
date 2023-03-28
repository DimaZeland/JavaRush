package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        grades.put("1", 1D);
        grades.put("2", 2D);
        grades.put("3", 3D);
        grades.put("4", 4D);
        grades.put("5", 5D);
    }
}
