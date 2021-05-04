package com.framework.Pages;

import com.framework.driver.Driver;
import com.framework.driver.DriverManager;
import com.framework.enums.WaitStrategy;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class OrangeHRMHomePage extends BasePage {

    private final By user_dropdown = By.id("welcome");
    private final By logoutBtn = By.xpath("//a[text()='Logout']");

    public OrangeHRMHomePage clickWelcome(){
        click(user_dropdown, WaitStrategy.CLICKABLE);
        return this;
    }

    public OrangeHRMHomePage doLogout(){
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        click(logoutBtn,WaitStrategy.CLICKABLE);
        return this;
    }

    public String getTitle(){
        return getPageTitle();
    }
}
