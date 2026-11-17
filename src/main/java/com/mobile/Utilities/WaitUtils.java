package com.mobile.Utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.mobile.MobileDriver.AppiumDriverManager.getDriver;

public class WaitUtils{
    private static WebDriverWait wait;

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
        //wait = new WebDriverWait(getDriver(), Duration.ofSeconds(100));
         wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void VisibilityOfElement(WebElement element) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(100));
        wait.until(ExpectedConditions.visibilityOf(element));

    }

}
