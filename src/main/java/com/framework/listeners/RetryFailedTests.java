package com.framework.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer {
    private int count = 0;
    private int retryLimit = 1;

    @Override
    public boolean retry(ITestResult result) {

        boolean value = count<retryLimit;
        count++;
        return value;
    }
}
