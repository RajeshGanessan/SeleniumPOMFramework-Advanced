package com.framework.driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private DriverManager(){

    }

    private static ThreadLocal<WebDriver> td = new ThreadLocal<>();

    //setting the driver instance
    public static void setDriver(WebDriver driver){
        td.set(driver);
    }
    //getting driver instance
    public static WebDriver getDriver(){
        return td.get();
    }

    //clearing the driver
    public static void unload(){
        td.remove();
    }
}
