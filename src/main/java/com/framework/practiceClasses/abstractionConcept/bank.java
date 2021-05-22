package com.framework.practiceClasses.abstractionConcept;

public abstract class bank {


    public abstract void loan(); // abstract method no body
    public  void withdraw(){
        System.out.println("Withdraw money");
    }

    public void deposit(){
        System.out.println("Deposit money");
    }
}
