package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        Thread n1 = new Thread(new SpecialThread());
        Thread n2 = new Thread(new SpecialThread());
        Thread n3 = new Thread(new SpecialThread());
        Thread n4 = new Thread(new SpecialThread());
        Thread n5 = new Thread(new SpecialThread());

        list.add(n1);
        list.add(n2);
        list.add(n3);
        list.add(n4);
        list.add(n5);
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
