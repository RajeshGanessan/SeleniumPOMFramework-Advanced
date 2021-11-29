package com.framework.report;

import com.aventstack.extentreports.Status;
import com.framework.enums.LogType;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class FrameworkLogger {

    private static  Consumer<String> PASS = (message) -> ExtentManager.getTest().pass(message);
    private static Consumer<String> FAIL = (message) -> ExtentManager.getTest().fail(message);
    private static Consumer<String> INFO = (message) -> ExtentManager.getTest().info(message);
    private static Consumer<String> LOG = System.out::println;

    private static Map<Enum,Consumer<String>> logger = new HashMap<>();

    static {
        logger.put(LogType.PASS,PASS);
        logger.put(LogType.FAIL,FAIL);
        logger.put(LogType.INFO,INFO);
        logger.put(LogType.LOG,LOG);
    }


    public static void log(LogType status,String message){
        logger.get(status).accept(message);
        Consumer
    }
}
