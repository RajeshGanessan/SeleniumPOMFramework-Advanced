package com.framework.Pages;

import com.framework.driver.DriverManager;
import com.framework.enums.WaitStrategy;
import org.openqa.selenium.By;

public class OrangeHRMLoginPage extends BasePage{

    private final By textbox_username = By.id("txtUsername");
    private final By textbox_password = By.id("txtPassword");
    private final By login_button =  By.id("btnLogin");


    public OrangeHRMLoginPage enterUserName(String username){
        sendKeys(textbox_username,username,"username");
        return this;
    }

    public OrangeHRMLoginPage enterPassword(String password){
        sendKeys(textbox_password,password,"password");
        return this;
    }

    public OrangeHRMHomePage clickLogin(){
        click(login_button, WaitStrategy.CLICKABLE,"login");
        return new OrangeHRMHomePage();
    }

}
