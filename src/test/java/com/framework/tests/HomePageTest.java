package com.framework.tests;

import com.framework.Pages.OrangeHRMHomePage;
import com.framework.Pages.OrangeHRMLoginPage;
import com.framework.driver.DriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public final class HomePageTest extends baseTest{


    @Test(dataProvider = "LoginTestData",enabled = false)
    public void newTest(String userName,String password){


    }

    @DataProvider(name="LoginTestData")
    public Object[][] getLoginData(){

        return new Object[][]{
                {"Admin","admin123"},
//                {"Admin","Admin123"},
//                {"admin","admin12"}
        };
    }
}
