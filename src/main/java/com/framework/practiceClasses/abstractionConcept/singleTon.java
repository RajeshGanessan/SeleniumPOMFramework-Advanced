package com.framework.practiceClasses.abstractionConcept;

public class singleTon {

    private static singleTon obj;

    private singleTon(){

    }

    public static singleTon createObject(){
        if(obj==null){
            obj = new singleTon();
        }
        return obj;
    }

    public void display(){
        System.out.println("Single Ton class ");
    }
}
