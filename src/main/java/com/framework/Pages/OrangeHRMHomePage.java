package com.framework.Pages;

import com.aventstack.extentreports.ExtentTest;
import com.framework.driver.Driver;
import com.framework.driver.DriverManager;
import com.framework.enums.WaitStrategy;
import com.framework.report.ExtentLogger;
import com.framework.report.ExtentManager;
import com.framework.report.ExtentReporter;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class OrangeHRMHomePage extends BasePage {

    private final By user_dropdown = By.id("welcome");
    private final By logoutBtn = By.xpath("//a[text()='Logout']");

    public OrangeHRMHomePage clickWelcome(){
        click(user_dropdown, WaitStrategy.CLICKABLE,"welcome ");
        return this;
    }

    public OrangeHRMHomePage doLogout(){
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        click(logoutBtn,WaitStrategy.CLICKABLE,"Logout");
        return this;
    }

    public String getTitle(){
        return getPageTitle();
    }
}
