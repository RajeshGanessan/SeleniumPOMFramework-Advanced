package com.framework.tests;

import com.framework.Pages.OrangeHRMHomePage;
import com.framework.Pages.OrangeHRMLoginPage;
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

    @Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    public void loginTest(Map<String,String> data){
        OrangeHRMLoginPage ohlp = new OrangeHRMLoginPage();
        OrangeHRMHomePage ohhp = ohlp.enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin();
       String title =  ohhp.clickWelcome().doLogout().getTitle();

       Assertions.assertThat(title)
               .isEqualTo("OrangeHRM");

    }

    @Test(dataProvider = "LoginTestData",dataProviderClass = DataProviderUtils.class)
    public void newTest(Map<String,String> data){
        OrangeHRMLoginPage ohlp = new OrangeHRMLoginPage();
        OrangeHRMHomePage ohhp = ohlp.enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin();
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
