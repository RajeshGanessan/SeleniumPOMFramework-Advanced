package com.framework.tests;

import com.framework.driver.Driver;
import com.framework.report.ExtentReporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class baseTest {


    @BeforeMethod
    protected void setUp(Object[] data ) throws Exception {
        Map<String,String> details = (Map<String, String>)data[0];
        Driver.initDriver(details.get("browser"));
    }

    @AfterMethod
    protected void tearDown(){
        Driver.tearDown();
    }
}
