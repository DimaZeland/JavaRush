
package com.javarush.task.task37.task3702;

import com.javarush.task.task37.task3702.female.FemaleFactory;
import com.javarush.task.task37.task3702.male.MaleFactory;

import static com.javarush.task.task37.task3702.FactoryProducer.HumanFactoryType.MALE;

public class FactoryProducer
{
    public static enum HumanFactoryType
    {
        MALE, FEMALE
    }

    public static AbstractFactory getFactory(HumanFactoryType type)
    {
        return type == MALE ? new MaleFactory() : new FemaleFactory();
    }
}
