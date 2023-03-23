package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        if (0 != args.length) {
            switch (args[0]) {
                case "-c": {
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i += 3) {
                            SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                            Date bd = null;
                            try {
                                bd = fm.parse(args[i + 2]);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }

                            if ("м".equals(args[i + 1]))
                                allPeople.add(Person.createMale(args[i], bd));
                            else
                                allPeople.add(Person.createFemale(args[i], bd));

                            System.out.println(allPeople.size() - 1);
                        }
                    }
                    break;
                }
                case "-i": {
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i++) {
                            int id = Integer.parseInt(args[i]);

                            String name = allPeople.get(id).getName();
                            String sex = allPeople.get(id).getSex() == Sex.MALE ? "м" : "ж";
                            Date bd = allPeople.get(id).getBirthDate();
                            SimpleDateFormat fm = new SimpleDateFormat("dd-MMM-yyyy");
                            String bdStr = fm.format(bd).toString();

                            System.out.println(name + ' ' + sex + ' ' + bdStr);
                        }
                    }
                    break;
                }
                case "-u": {
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i += 4) {
                            int id = Integer.parseInt(args[i]);
                            String name = args[i + 1];
                            Sex sex = "м".equals(args[i + 2]) ? Sex.MALE : Sex.FEMALE;
                            SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy");
                            Date bd = null;
                            try {
                                bd = fm.parse(args[i + 3]);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }

                            allPeople.get(id).setName(name);
                            allPeople.get(id).setSex(sex);
                            allPeople.get(id).setBirthDate(bd);
                        }
                    }
                    break;
                }
                case "-d": {
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i++) {
                            int id = Integer.parseInt(args[i]);
                            allPeople.get(id).setName(null);
                            allPeople.get(id).setSex(null);
                            allPeople.get(id).setBirthDate(null);
                        }
                    }
                    break;
                }
            }
        }
    }
}
