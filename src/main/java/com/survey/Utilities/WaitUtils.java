package com.survey.Utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.survey.Utilities.AppiumDriverManager.getDriver;

public class WaitUtils{
    public static WebDriverWait wait;

    static{
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(100));
    }

    public static void standedWait(int timeout) throws InterruptedException {

        Thread.sleep(1000*timeout);
    }

//    public static void webDriverWaitInit() throws InterruptedException {
//        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(100));
//    }

    public static void waitForElementClickable(WebElement element) throws InterruptedException {
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(100));
       // return wait.until(ExpectedCondition.waitForElementClickable(waitForElementClickable();));
    }

    public static void VisibilityOfElement(WebElement element) throws InterruptedException {
        //WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(100));
        wait.until(ExpectedConditions.visibilityOf(element));

    }

}
