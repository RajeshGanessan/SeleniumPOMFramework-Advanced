package com.framework.constants;

import com.framework.enums.ConfigProperties;
import com.framework.utils.ReadProperty;

public class AppConstants {

    private static final String CHROMEDRIVERPATH = System.getProperty("user.dir") + "/test/chromedriver";
    private static final int EXPLICITWAITTIMEOUT  = 10;
    private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/extent-test-output/";
    private static  String extentreportfilepath ="";
    private static String TESTCONFIGPATH = System.getProperty("user.dir") + "/src/main/java/com/framework/TestData/testConfig.xlsx";


    public static String getEXTENTREPORTPATH() {
        if(extentreportfilepath.isEmpty()){
            extentreportfilepath = createReportPath();
        }
        return extentreportfilepath;
    }

    private static String createReportPath(){
        if(ReadProperty.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")){
            return EXTENTREPORTFOLDERPATH + System.currentTimeMillis()+"/index.html";
        } else {
            return EXTENTREPORTFOLDERPATH + "/index.html";
        }
    }

    public static String getCHROMEDRIVERPATH() {
        return CHROMEDRIVERPATH;
    }

    public static String getTESTCONFIGPATH(){
        return TESTCONFIGPATH;
    }

    public static int getExplicitWaitTimeout(){
        return EXPLICITWAITTIMEOUT;
    }

}
