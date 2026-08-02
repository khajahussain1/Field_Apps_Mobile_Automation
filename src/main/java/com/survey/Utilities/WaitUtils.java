package com.survey.Utilities;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.survey.Utilities.AppiumDriverInitialization.getDriver;

public class WaitUtils extends Comman_Methods{
    public static WebDriverWait wait;

    public static void standedWait(int timeout) throws InterruptedException {

        Thread.sleep(1000*timeout);
    }

    public static void webDriverWaitInit() throws InterruptedException {
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(100));
    }

    public static void waitForElementClickable() throws InterruptedException {
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(100));
       // return wait.until(ExpectedCondition.waitForElementClickable(waitForElementClickable();));
    }

}
