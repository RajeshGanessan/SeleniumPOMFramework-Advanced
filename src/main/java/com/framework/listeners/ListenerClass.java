package com.framework.listeners;

import org.testng.*;

public class ListenerClass implements ITestListener, ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        System.out.println("Before suite in listener");
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("After suite in listener");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Before method in listener");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("after method  in listener");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("after method in listener :Failure");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("after method in listener : Skipped ");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Before suite in listener");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Before suite in listener");
    }
}
