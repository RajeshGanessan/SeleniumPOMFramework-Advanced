package com.framework.listeners;

import com.framework.enums.ConfigProperties;
import com.framework.utils.ReadProperty;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer {
    private int count = 0;
    private int retryLimit = 1;

    @Override
    public boolean retry(ITestResult result) {
        boolean value = false;
        if(ReadProperty.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
             value = count < retryLimit;
            count++;
        }
        return value;
    }
}
