package com.javarush.task.task15.task1529;

public class Plane implements CanFly
{
    private int passangers;
    @Override
    public void fly()
    {

    }

    public Plane(int passangers)
    {
    this.passangers = passangers;
    }
}
