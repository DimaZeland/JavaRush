package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        if (0 != args.length) {
            if ("-c".equals(args[0])) {
                SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                Date bd = null;
                try {
                    bd = fm.parse(args[3]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                if ("м".equals(args[2]))
                    allPeople.add(Person.createMale(args[1], bd));
                else
                    allPeople.add(Person.createFemale(args[1], bd));

                System.out.println(allPeople.size() - 1);
            } else if ("-r".equals(args[0])) {
                int id = Integer.parseInt(args[1]);

                String name = allPeople.get(id).getName();
                String sex = allPeople.get(id).getSex() == Sex.MALE ? "м" : "ж";
                Date bd = allPeople.get(id).getBirthDate();
                SimpleDateFormat fm = new SimpleDateFormat("dd-MMM-yyyy");
                String bdStr = fm.format(bd).toString();

                System.out.println(name + ' ' + sex + ' ' + bdStr);
            } else if ("-u".equals(args[0])) {
                int id = Integer.parseInt(args[1]);
                String name = args[2];
                Sex sex = "м".equals(args[3]) ? Sex.MALE : Sex.FEMALE;
                SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy");
                Date bd = null;
                try {
                    bd = fm.parse(args[4]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                allPeople.get(id).setName(name);
                allPeople.get(id).setSex(sex);
                allPeople.get(id).setBirthDate(bd);
            } else if ("-d".equals(args[0])) {
                int id = Integer.parseInt(args[1]);
                allPeople.get(id).setName(null);
                allPeople.get(id).setSex(null);
                allPeople.get(id).setBirthDate(null);
            }
        }
    }
}
