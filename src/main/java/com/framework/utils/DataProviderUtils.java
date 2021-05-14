package com.framework.utils;

import com.framework.constants.AppConstants;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class DataProviderUtils {

    private static List<Map<String,String>> list = new ArrayList<>();

    @DataProvider
    public static Object[] getData(Method m){
        String methodName = m.getName();
        if(list.isEmpty()){
            list = ExcelUtils.getTestDetails(AppConstants.getIterationSheet());
        }
        List<Map<String,String>> filteredTests = new ArrayList<>();

        for(int i=0;i<list.size();i++){

            if(list.get(i).get("testname").equalsIgnoreCase(methodName) &&
                    list.get(i).get("execute").equalsIgnoreCase("yes")){
                    filteredTests.add(list.get(i));
                }
            }
        return filteredTests.toArray();
    }
}
