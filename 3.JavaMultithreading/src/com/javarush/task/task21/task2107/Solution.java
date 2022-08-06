package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты
*/

public class Solution implements Cloneable
{

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try
        {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e)
        {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap();

    @Override
    public Solution clone() throws CloneNotSupportedException
    {
        Solution solution = new Solution();

        for(String name : users.keySet())
        {
            int age = users.get(name).age;
            solution.users.put(name,new User(age,name));
        }

        return solution;
    }

    public static class User implements Cloneable
    {
        int age;
        String name;

        public User(int age, String name)
        {
            this.age = age;
            this.name = name;
        }

        @Override
        public User clone() throws CloneNotSupportedException
        {
            return new User(this.age, this.name);
        }

        @Override
        public int hashCode()
        {
            int result = null == this.name ? 0 : name.hashCode();

            result = 31 * (result + age);
            return result;
        }

        @Override
        public boolean equals(Object obj)
        {
            if(this == obj)
                return true;

            if(this.getClass() != obj.getClass())
                return false;

            User user = (User) obj;

            if(this.age == user.age
                    && (this.name == user.name || this.name.equals(user.name)))
                return true;
            else
                return false;
        }
    }
}
