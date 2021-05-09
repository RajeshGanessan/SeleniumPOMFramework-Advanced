package com.framework.report;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {


    private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();


    public static void setExtent(ExtentTest test){
        extTest.set(test);
    }

    public static ExtentTest getTest(){
        return extTest.get();
    }

    public static void unload(){
        extTest.remove();
    }
}
