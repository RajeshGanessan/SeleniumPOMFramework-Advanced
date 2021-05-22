package com.framework.practiceClasses.abstractionConcept;

import java.awt.*;

public class BankTest {

    public static void main(String[] args) {

        HDFC hdfc = new HDFC();
        hdfc.loan();

        Car car = new alto();
        car.refuel();


        alto alto = new alto();
        alto.refuel();
        alto.newMethod();
        Car.staticMethod();

        singleTon single =singleTon.createObject();
        single.display();

    }
}
