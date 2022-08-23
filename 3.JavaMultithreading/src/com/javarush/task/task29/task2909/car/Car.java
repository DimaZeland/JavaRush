package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;
    private int type;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
        this.type = type;
    }

    public void fill(double numberOfLiters) throws Exception{
        if (numberOfLiters < 0)
            throw new Exception();
        else
        fuel += numberOfLiters;
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        if (isSummer(date,SummerStart,SummerEnd))
            return getSummerConsumption(length);
         else
             return getWinterConsumption(length);
    }

    public int getNumberOfPassengersCanBeTransferred() {
        if (canPassengersBeTransferred()) {
            return numberOfPassengers;
        }
        return 0;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        if (numberOfPassengers > 0)
            fastenPassengersBelts();

            fastenDriverBelt();
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    abstract public int getMaxSpeed();/* {
        final int MAX_TRUCK_SPEED = 80;
        final int MAX_SEDAN_SPEED = 120;
        final int MAX_CABRIOLET_SPEED = 90;

        if (type == TRUCK)
            return MAX_TRUCK_SPEED;
        if (type == SEDAN)
            return MAX_SEDAN_SPEED;
        return MAX_CABRIOLET_SPEED;
    }*/

    static public Car create(int type, int numberOfPassengers)
    {
        Car car = null;

        switch (type)
        {
            case TRUCK:
                car = new Truck(numberOfPassengers);
                break;
            case SEDAN:
                car = new Sedan(numberOfPassengers);
                break;
            case CABRIOLET:
                car = new Cabriolet(numberOfPassengers);
                break;
        }
    return car;
    }

    public boolean isSummer(Date date, Date summerStart, Date summerEnd)
    {
        return date.after(summerStart) && date.before(summerEnd);
    }

    public double getWinterConsumption(int length)
    {
        return length * winterFuelConsumption + winterWarmingUp;
    }

    public double getSummerConsumption(int length)
    {
        return length * summerFuelConsumption;
    }

    private boolean canPassengersBeTransferred()
    {
        return isDriverAvailable() && fuel > 0 ? true : false;
    }
}