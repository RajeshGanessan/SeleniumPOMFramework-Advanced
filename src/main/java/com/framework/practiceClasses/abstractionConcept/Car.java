package com.framework.practiceClasses.abstractionConcept;

public interface Car {

      int amount = 100;
     void start();
     void turnOff();
     void refuel();

    default void newMethod(){
        System.out.println("default Method");
    }

    static void staticMethod(){
        System.out.println("Static Method ");
    }
}
