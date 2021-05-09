package com.framework.tests;

import com.framework.Pages.OrangeHRMHomePage;
import com.framework.Pages.OrangeHRMLoginPage;
import com.framework.report.ExtentReporter;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.framework.*;

public class OrangeHRMTest extends baseTest {

    private OrangeHRMTest(){

    }

    @Test(dataProvider = "LoginTestData")
    public void loginTest(String userName,String password){
        OrangeHRMLoginPage ohlp = new OrangeHRMLoginPage();
        OrangeHRMHomePage ohhp = ohlp.enterUserName(userName).enterPassword(password).clickLogin();
       String title =  ohhp.clickWelcome().doLogout().getTitle();

       Assertions.assertThat(title)
               .isEqualTo("OrangeHRM");

    }

    @DataProvider(name="LoginTestData" ,parallel = true)
    public Object[][] getData(){

        return new Object[][]{
                {"Admin","admin123"},
                {"Admin","admin123"},
//                {"admin","admin12"}
        };
    }
}
