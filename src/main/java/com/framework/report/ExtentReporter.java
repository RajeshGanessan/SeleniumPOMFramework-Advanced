package com.framework.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ExtentReporter  {

    private static ExtentReports extent;


    public static void initReports(){
        if(Objects.isNull(extent)){
             extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
            extent.attachReporter(spark);

            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("Test Report ");
            spark.config().setReportName("Sample Report");
        }
    }

    public static void flushReports() throws IOException {
        if(Objects.nonNull(extent)){
            extent.flush();
            Desktop.getDesktop().browse(new File("index.html").toURI());
        }
    }

    public static void createTest(String testcaseName){
        ExtentTest test  = extent.createTest(testcaseName);
        ExtentManager.setExtent(test);
    }

}
