package com.framework.driver;

import com.framework.utils.ReadProperty;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Objects;

public class Driver {


    public static void initDriver() throws Exception {

        //checking whether the driver instance is null
        if(Objects.isNull(DriverManager.getDriver())) {
            WebDriverManager.chromedriver().setup();
            DriverManager.setDriver(new ChromeDriver());
            DriverManager.getDriver().get(ReadProperty.get("url"));
        }
    }

    public static void tearDown(){
       if(Objects.nonNull(DriverManager.getDriver())){
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }


}
