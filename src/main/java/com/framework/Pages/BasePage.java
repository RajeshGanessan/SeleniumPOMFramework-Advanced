package com.framework.Pages;

import com.framework.constants.AppConstants;
import com.framework.driver.Driver;
import com.framework.driver.DriverManager;
import com.framework.enums.WaitStrategy;
import com.framework.report.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected void click(By by, WaitStrategy waitStrategy,String elementName){
        if(waitStrategy == WaitStrategy.CLICKABLE) {
            waitTillElementClickable(by);
        } else if(waitStrategy == WaitStrategy.PRESENCE){
            waitTillElementPresence(by);
        }
        DriverManager.getDriver().findElement(by).click();
        ExtentLogger.pass(elementName + " is clicked!");

    }

    protected void sendKeys(By by,String value,String elementName){

        DriverManager.getDriver().findElement(by).sendKeys(value);
        ExtentLogger.pass(value + " is entered successfully on " + elementName,true);
    }

    protected String getPageTitle(){
        return  DriverManager.getDriver().getTitle();
    }

    private void waitTillElementClickable(By by){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), AppConstants.getExplicitWaitTimeout());
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    private void waitTillElementPresence(By by){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), AppConstants.getExplicitWaitTimeout());
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
