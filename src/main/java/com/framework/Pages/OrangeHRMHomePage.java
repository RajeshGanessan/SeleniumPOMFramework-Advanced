package com.framework.Pages;

import com.framework.driver.Driver;
import com.framework.driver.DriverManager;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class OrangeHRMHomePage {

    private final By user_dropdown = By.id("welcome");
    private final By logoutBtn = By.xpath("//a[text()='Logout']");

    public OrangeHRMHomePage clickWelcome(){
        DriverManager.getDriver().findElement(user_dropdown).click();
        return this;
    }

    public OrangeHRMHomePage doLogout(){
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        DriverManager.getDriver().findElement(logoutBtn).click();
        return this;
    }

    public String getTitle(){
        return DriverManager.getDriver().getTitle();
    }
}
