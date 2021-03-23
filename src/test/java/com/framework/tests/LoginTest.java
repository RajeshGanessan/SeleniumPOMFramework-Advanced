package com.framework.tests;

import com.framework.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public final class  LoginTest extends baseTest {

    @Test
    public void test1(){
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("twitter", Keys.ENTER);
    }

    @Test
    public void test2(){
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("selenium",Keys.ENTER);
    }
}
