package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable
{
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map)
    {
        this.map = map;
    }

    @Override
    public void run()
    {
        try
        {
            for (int i = 1; true; ++i)
            {
                String index = String.valueOf(i);
                map.put(index, "Some text for " + index);
                Thread.sleep(500);
            }
        } catch (InterruptedException e)
        {
            System.out.println(Thread.currentThread().getName() + " thread was terminated");
        }
    }
}
