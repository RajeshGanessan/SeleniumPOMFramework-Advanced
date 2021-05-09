package com.framework.tests;

import com.framework.driver.Driver;
import com.framework.report.ExtentReporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class baseTest {

    @BeforeSuite
    public void beforeSuite(){
        ExtentReporter.initReports();
    }

    @AfterSuite
    public void afterSuite() throws IOException {
        ExtentReporter.flushReports();
    }

    @BeforeMethod
    protected void setUp() throws Exception {
        Driver.initDriver();
    }

    @AfterMethod
    protected void tearDown(){
        Driver.tearDown();
    }
}
