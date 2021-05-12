package com.framework.report;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.framework.enums.ConfigProperties;
import com.framework.utils.ReadProperty;
import com.framework.utils.ScreenshotUtils;

public final class ExtentLogger extends ExtentManager {

    private ExtentLogger() {
    }

    public static void pass(String message) {
        ExtentManager.getTest().pass(message);
    }

    public static void fail(String message) {
        ExtentManager.getTest().fail(message);
    }

    public static void skip(String message) {
        ExtentManager.getTest().skip(message);
    }

    public static void pass(String message, boolean isScreenshotNeeded) {
        if (ReadProperty.get(ConfigProperties.PASSEDTESTSSCREENSHOTS).equalsIgnoreCase("yes")
                && isScreenshotNeeded) {
            ExtentManager.getTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        } else {
            pass(message);
        }
    }

    public static void fail(String message, boolean isScreenshotNeeded) {
        if (ReadProperty.get(ConfigProperties.FAILEDTESTSSCREENSHOTS).equalsIgnoreCase("yes")
                && isScreenshotNeeded) {
            ExtentManager.getTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        } else {
            fail(message);
        }
    }

    public static void skip(String message, boolean isScreenshotNeeded) {
        if (ReadProperty.get(ConfigProperties.SKIPPEDTESTSCREENSHOTS).equalsIgnoreCase("yes")
                && isScreenshotNeeded) {
            ExtentManager.getTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        } else {
            skip(message);
        }
    }



}
