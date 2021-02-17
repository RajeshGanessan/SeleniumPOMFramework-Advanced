package com.framework.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

   private static WebDriver driver;

   private static ThreadLocal<WebDriver> td = new ThreadLocal<>();

   //getting driver instance
   public static WebDriver getDriver(){
       return td.get();
   }

   //setting the driver instance
    public static void setDriver(WebDriver driver){
       td.set(driver);
    }
    public static void initDriver(){
        //checking whether the driver instance is null
        if(driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            setDriver(driver);
            getDriver().get("https://google.com");
        }
    }

    public static void tearDown(){
       if(getDriver()!=null){
            getDriver().quit();
            unload();
        }
    }

    //clearing the driver
    public static void unload(){
       td.remove();
    }
}
