package com.framework.practiceClasses.abstractionConcept;

public class alto implements Car{
    @Override
    public void start() {
        System.out.println("Starting car");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off car");
    }

    @Override
    public void refuel() {
        System.out.println("Refueling the car");
    }


}
