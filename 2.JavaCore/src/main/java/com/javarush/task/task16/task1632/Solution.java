package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new T1());
        threads.add(new T2());
        threads.add(new T3());
        threads.add(new T4());
        threads.add(new T5());

    }

    public static void main(String[] args) throws InterruptedException {
        /*for (Thread t: threads)
        {
            t.start();
        }

        threads.get(2).join();*/
    }

    public static class T1 extends Thread {
        @Override
        public void run() {
            while (true) ;
        }
    }

    public static class T2 extends Thread {
        @Override
        public void run() {
            try {
                sleep(0);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class T3 extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("Ура");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public static class T4 extends Thread implements Message {
        @Override
        public void run() {
            while (!isInterrupted()) {
            }
        }

        @Override
        public void showWarning() {
            this.interrupt();
        }
    }

    public static class T5 extends Thread {
        @Override
        public void run() {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = "";
            Double sum = .0;
            try {
                while (!"N".equals(str = br.readLine()))
                    sum += Double.parseDouble(str);

                System.out.println(sum.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}