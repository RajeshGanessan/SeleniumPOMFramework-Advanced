package com.framework.utils;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class DataProviderUtils {

    @DataProvider
    public static Object[] getData(Method m){
        String methodName = m.getName();
        List<Map<String,String>> dataMap = ExcelUtils.getTestDetails("Data");

        List<Map<String,String>> filteredTests = new ArrayList<>();

        for(int i=0;i<dataMap.size();i++){

            if(dataMap.get(i).get("testname").equalsIgnoreCase(methodName)){
                if(dataMap.get(i).get("execute").equalsIgnoreCase("yes")){
                    filteredTests.add(dataMap.get(i));
                }
            }
        }
        return filteredTests.toArray();
    }
}
