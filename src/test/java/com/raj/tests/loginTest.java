package com.raj.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class loginTest {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();

        driver.get("https://google.com");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test1(){
        driver.findElement(By.name("q")).sendKeys("twitter", Keys.ENTER);
    }

    @Test
    public void test2(){
        driver.findElement(By.name("q")).sendKeys("selenium",Keys.ENTER);
    }
}
