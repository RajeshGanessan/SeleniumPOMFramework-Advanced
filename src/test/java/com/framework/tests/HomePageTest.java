package com.framework.tests;

import com.framework.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public final class HomePageTest extends baseTest{
    @Test
    public void test1(){
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("NaveenAutomationLabs", Keys.ENTER);
    }

//    @Test
//    public void test2(){
//        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Mukes otwani",Keys.ENTER);
//    }

}
