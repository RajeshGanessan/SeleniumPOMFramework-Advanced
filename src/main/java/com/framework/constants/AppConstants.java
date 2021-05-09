package com.framework.constants;

public class AppConstants {

    private static final String CHROMEDRIVERPATH = System.getProperty("user.dir") + "/test/chromedriver";
    private static final int EXPLICITWAITTIMEOUT  = 10;

    public static String getCHROMEDRIVERPATH() {
        return CHROMEDRIVERPATH;
    }

    public static int getExplicitWaitTimeout(){
        return EXPLICITWAITTIMEOUT;
    }

}
