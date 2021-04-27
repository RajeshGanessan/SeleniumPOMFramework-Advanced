package com.framework.tests;

import com.framework.Pages.OrangeHRMHomePage;
import com.framework.Pages.OrangeHRMLoginPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import com.framework.*;

public class OrangeHRMTest extends baseTest {

    private OrangeHRMTest(){

    }

    @Test
    public void loginTest(){
        OrangeHRMLoginPage ohlp = new OrangeHRMLoginPage();
        OrangeHRMHomePage ohhp = ohlp.enterUserName("Admin").enterPassword("admin123").clickLogin();
       String title =  ohhp.clickWelcome().doLogout().getTitle();

       Assertions.assertThat(title)
               .isEqualTo("OrangeHRM");

    }
}
