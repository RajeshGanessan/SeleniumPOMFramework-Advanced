package com.framework.Pages;

import com.framework.driver.DriverManager;
import org.openqa.selenium.By;

public class OrangeHRMLoginPage {

    private final By textbox_username = By.id("txtUsername");
    private final By textbox_password = By.id("txtPassword");
    private final By login_button =  By.id("btnLogin");


    public OrangeHRMLoginPage enterUserName(String username){
        DriverManager.getDriver().findElement(textbox_username).sendKeys(username);
        return this;
    }

    public OrangeHRMLoginPage enterPassword(String password){
        DriverManager.getDriver().findElement(textbox_password).sendKeys(password);
        return this;
    }

    public OrangeHRMHomePage clickLogin(){
        DriverManager.getDriver().findElement(login_button).click();
        return new OrangeHRMHomePage();
    }

}
