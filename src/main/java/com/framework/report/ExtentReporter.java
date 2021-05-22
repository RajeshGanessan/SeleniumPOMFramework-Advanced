package com.framework.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.framework.constants.AppConstants;
import com.framework.enums.CategoryType;
import com.framework.exceptions.InvalidFilePathException;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class ExtentReporter  {

    private static ExtentReports extent;


    public static void initReports(){
        if(Objects.isNull(extent)){
             extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(AppConstants.getEXTENTREPORTPATH());
            extent.attachReporter(spark);

            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("Test Report ");
            spark.config().setReportName("Sample Report");
        }
    }

    public static void flushReports() {
        if(Objects.nonNull(extent)) {
            extent.flush();
        }
            ExtentManager.unload();
        try {
            Desktop.getDesktop().browse(new File(AppConstants.getEXTENTREPORTPATH()).toURI());
        } catch(IOException e) {
            e.printStackTrace();
        }

    }

    public static void createTest(String testcaseName){
        ExtentTest test  = extent.createTest(testcaseName);
        ExtentManager.setExtent(test);
    }

    public static void addAuthor(String author){
        ExtentManager.getTest().assignAuthor(author);
    }

    public static void assignCategory(CategoryType[] category){
        Arrays.asList(category).forEach(s -> ExtentManager.getTest().assignCategory(Arrays.toString(category)));
    }

}
