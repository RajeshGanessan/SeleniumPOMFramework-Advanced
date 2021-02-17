package com.framework.tests;

import com.framework.driver.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class baseTest {

    @BeforeMethod
    public void setUp(){
        DriverFactory.initDriver();
    }

    @AfterMethod
    public void tearDown(){
        DriverFactory.tearDown();
    }
}
