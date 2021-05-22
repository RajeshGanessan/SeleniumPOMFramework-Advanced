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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class OrangeHRMHomePage extends BasePage {

    @FindBy(id = "welcome")
    private WebElement userDropdown;

    public OrangeHRMHomePage(){
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

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
