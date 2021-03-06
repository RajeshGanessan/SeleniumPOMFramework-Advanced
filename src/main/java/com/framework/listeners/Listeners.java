package com.framework.listeners;

import com.aventstack.extentreports.ExtentTest;
import com.framework.CustomAnnotations.AppAnnotations;
import com.framework.report.ExtentLogger;
import com.framework.report.ExtentManager;
import com.framework.report.ExtentReporter;
import org.testng.*;

import java.io.IOException;

public class Listeners implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        ExtentReporter.initReports();
    }

    @Override
    public void onFinish(ISuite suite) {
            ExtentReporter.flushReports();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReporter.createTest(result.getMethod().getMethodName());
        ExtentReporter.addAuthor(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(AppAnnotations.class).author());
        ExtentReporter.assignCategory(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(AppAnnotations.class).category());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + "PASSED !!",true);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName() + "FAILED !!",true);
        ExtentLogger.fail(result.getThrowable().toString());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() + "SKIPPED !!");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        /*
        * For now not using this.
        * */
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        /*
         * For now not using this.
         * */
    }

    @Override
    public void onStart(ITestContext context) {
        /*
         * For now not using this.
         * */
    }

    @Override
    public void onFinish(ITestContext context) {
        /*
         * For now not using this.
         * */
    }
}
