package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread
{
    private Thread target;

    public LoggingStateThread(Thread target)
    {
        this.target = target;
    }

    @Override
    public void run()
    {
        String oldState  = "";
        String newState = "";

        while (!newState.equals("TERMINATED"))
        {
            oldState = target.getState().toString();

            if(!oldState.equals(newState))
            {
                newState = oldState;
                System.out.println(newState);
            }
            else
                try
                {
                    Thread.sleep(100);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
        }
    }
}
