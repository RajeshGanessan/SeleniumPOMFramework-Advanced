package com.framework.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class excelTest {


    @Test(priority = 1)
    public void readExcel(){


        Object[][] data = excelUtil.getTestData("Login");
        System.out.println(Arrays.deepToString(data));
    }
}
