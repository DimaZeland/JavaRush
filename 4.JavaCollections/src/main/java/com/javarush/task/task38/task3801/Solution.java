package com.javarush.task.task38.task3801;

/* 
исправь ошибки в коде
*/

public class Solution {
    public static void main(String[] args) {
        if (args.length > 0) {
            try {
                System.out.println("имя содержит " + NameChecker.getNumberOfCharacters(args[0]) + " символов");
            } catch (NameIsNullException e) {
                System.out.println("Ошибка:мя не задано");
            } catch (NameIsEmptyException e) {
                System.out.println("Ошибка:мя пустое");
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
}
