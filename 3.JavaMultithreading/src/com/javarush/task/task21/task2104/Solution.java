package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/

public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object n) {
        if(this == n)
            return true;
        if(! (n instanceof Solution))
            return false;

        Solution guest = (Solution) n;

        return (first == guest.first ||
                (first != null && first.equals(guest.first)))
                && (last == guest.last || (last != null && last.equals(guest.last)));
       /* if (first != null ? !first.equals(solution.first) : solution.first != null) return false;
        return last != null ? last.equals(solution.last) : solution.last == null;*/
    }
    
    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (last != null ? last.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
