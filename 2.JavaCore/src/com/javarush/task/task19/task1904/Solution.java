package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner s) {
            fileScanner = s;
        }

        @Override
        public Person read() throws IOException {
            //Scanner scanner = new Scanner(System.in);

            String line = fileScanner.nextLine();

            String[] data = line.split(" ");


            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];
            int day = Integer.parseInt(data[3]);
            int month = Integer.parseInt(data[4]) - 1;
            int year = Integer.parseInt(data[5]) - 1900;
            Date bd = new Date(year, month, day);

            return new Person(firstName, middleName, lastName, bd);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
