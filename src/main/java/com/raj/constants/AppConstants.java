package com.raj.constants;

public class AppConstants {

    private static final String CHROMEDRIVERPATH = System.getProperty("user.dir") + "/test/chromedriver";

    public static String getCHROMEDRIVERPATH() {
        return CHROMEDRIVERPATH;
    }

}
