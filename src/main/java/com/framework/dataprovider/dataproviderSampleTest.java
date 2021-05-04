package com.framework.dataprovider;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataproviderSampleTest {

    @Test(dataProvider = "getEmployeeData")
    public void test1(Employee emp){
        System.out.println(emp.getName());
        Assert.assertTrue(true);
    }

    @DataProvider
    public Object[] getData(){
        return new String[]{
                "test1", "test2"
        };
    }

    @DataProvider
    public Object[] getEmployeeData(){
        return new Employee[]{
               new Employee("Rajesh","one"),
               new Employee("dinesh","two"),
                new Employee("ganessan","three")
        };
    }

}
