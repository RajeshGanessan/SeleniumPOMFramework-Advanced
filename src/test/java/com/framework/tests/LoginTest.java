//package com.framework.tests;
//
//import com.framework.driver.DriverManager;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import java.util.Arrays;
//
//public final class  LoginTest extends baseTest {
//
////    @Test
////    public void test1(){
////        DriverManager.getDriver().findElement(By.name("q")).sendKeys("twitter", Keys.ENTER);
////    }
////
////    @Test
////    public void test2(){
////        DriverManager.getDriver().findElement(By.name("q")).sendKeys("selenium",Keys.ENTER);
////    }
//
//    @DataProvider
//    public Object[][] getSignUpData(){
//        String sheetName = "Login";
//        Object data[][] = excelUtil.getTestData("Login");
//        System.out.println(Arrays.deepToString(data));
//        return data;
//
//    }
//
//    @Test(priority = 1, dataProvider = "getSignUpData")
//    public void fetchAllData(){
//
////        System.out.println(Arrays.deepToString(getSignUpData()));
//        getSignUpData();
//
//    }
//}
