package com.framework.tests;

import com.framework.Pages.OrangeHRMHomePage;
import com.framework.Pages.OrangeHRMLoginPage;
import com.framework.listeners.RetryFailedTests;
import com.framework.report.ExtentReporter;
import com.framework.utils.DataProviderUtils;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.framework.*;

import java.util.Map;

public class OrangeHRMTest extends baseTest {

    private OrangeHRMTest(){

    }

    @Test
    public void loginTest(Map<String,String> data){
        OrangeHRMLoginPage ohlp = new OrangeHRMLoginPage();
        System.out.println(data.get("username") + " | " + data.get("password"));
        OrangeHRMHomePage ohhp = ohlp.enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin();
       String title =  ohhp.clickWelcome().doLogout().getTitle();

       Assertions.assertThat(title)
               .isEqualTo("OrangeHRM");

    }

    @Test
    public void newTest(Map<String,String> data){
        OrangeHRMLoginPage ohlp = new OrangeHRMLoginPage();
        OrangeHRMHomePage ohhp = ohlp.enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin();
        String title =  ohhp.clickWelcome().doLogout().getTitle();

        Assertions.assertThat(title)
                .isEqualTo("OrangeHRM");

    }

    @Test(dataProvider = "LoginTestData",enabled = false)
    public void newTest(String userName,String password){
        OrangeHRMLoginPage ohlp = new OrangeHRMLoginPage();
        OrangeHRMHomePage ohhp = ohlp.enterUserName(userName).enterPassword(password).clickLogin();
        String title =  ohhp.clickWelcome().doLogout().getTitle();

        Assertions.assertThat(title)
                .isEqualTo("OrangeHRM");

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
