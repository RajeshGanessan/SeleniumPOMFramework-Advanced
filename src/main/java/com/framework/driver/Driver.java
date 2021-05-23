package com.framework.driver;

import com.framework.enums.ConfigProperties;
import com.framework.exceptions.BrowserInvocationException;
import com.framework.utils.ReadProperty;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Objects;

public class Driver {


    public static void browserInvocation(String browser)  {
        //checking whether the driver instance is null
        if(Objects.isNull(DriverManager.getDriver())) {
            try {
                DriverManager.setDriver(DriverFactory.getDriver(browser));
            } catch (MalformedURLException e){
                throw new BrowserInvocationException("Browser invocation failed!!!");
            }
            DriverManager.getDriver().get(ReadProperty.get(ConfigProperties.URL));
        }
    }

    public static void tearDown(){
       if(Objects.nonNull(DriverManager.getDriver())){
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }


}
