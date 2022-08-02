package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/

public class Solution
{
    public static void main(String[] args)
    {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try
        {
            File yourFile = File.createTempFile("D:\\1.txt", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            javaRush.users.add(javaRush.createUser());
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e)
        {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush
    {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception
        {
            PrintWriter writer = new PrintWriter(outputStream);

            if (0 < users.size())
                for (User user : users)
                {
                    writer.println(user.getFirstName());
                    writer.println(user.getLastName());
                    writer.println(String.valueOf(user.getBirthDate().getTime()));
                    writer.println(String.valueOf(user.isMale()));
                    writer.println(user.getCountry().getDisplayName());
                }

            writer.close();
        }

        public void load(InputStream inputStream) throws Exception
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            
                while (reader.ready())
                {
                    String firstName = reader.readLine();
                    String lastName = reader.readLine();
                    Date birthDate = new Date(Long.valueOf(reader.readLine()));
                    boolean isMale = Boolean.valueOf(reader.readLine());
                    String countryString = reader.readLine();
                    User.Country country = countryString.equals("Ukraine") ? User.Country.UKRAINE
                            : countryString.equals("Russia") ? User.Country.RUSSIA : User.Country.OTHER;

                    User user = new User();
                    user.setFirstName(firstName);
                    user.setLastName(lastName);
                    user.setBirthDate(birthDate);
                    user.setMale(isMale);
                    user.setCountry(country);

                    users.add(user);
                }

            reader.close();
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode()
        {
            return users != null ? users.hashCode() : 0;
        }

        public User createUser()
        {
            User user = new User();
            user.setFirstName("Andrey");
            user.setLastName("Ivanov");
            user.setBirthDate(new Date());
            user.setMale(true);
            user.setCountry(User.Country.OTHER);

            return user;
        }
    }
}
