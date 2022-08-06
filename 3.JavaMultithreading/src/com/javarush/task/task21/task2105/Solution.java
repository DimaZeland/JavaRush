package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/

public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;

        if (!(o instanceof Solution))
            return false;

        Solution n = (Solution) o;

        return (first == n.first || (null != first && n.first.equals(first)))
                &&
                (last == n.last  || (null != last  && n.last.equals(last  )));
    }

    @Override
    public int hashCode()
    {
        int result = null != first ? first.hashCode() : 0;
        result    += null != last  ?  last.hashCode() : 0;
        result *= 31;
        return result;
        
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
