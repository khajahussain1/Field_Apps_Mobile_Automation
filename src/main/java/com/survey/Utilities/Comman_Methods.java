package com.survey.Utilities;

import io.appium.java_client.TouchAction;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.apache.log4j.Logger;

import static com.survey.Utilities.AppiumDriverManager.getDriver;

public class Comman_Methods {
    public static WaitUtils waitUtils;
    public static JavascriptExecutor jscript;
    public static TouchAction touchAction;
    public Logger logger = Logger.getLogger(Comman_Methods.class);
    protected static void actionInit() {
    }

    protected static void javascriptInit() {
    }

    public static byte[] embedScreenshot(){
        byte[] srcBytes = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
        return srcBytes;
    }

    public static void click_drop_down(WebElement element) throws InterruptedException {
        //waitUtils.waitForElementClickable(element);
        Thread.sleep(500);
        element.click();

           }
    public static void enter_text(WebElement element, String value ) throws InterruptedException {
        WaitUtils.VisibilityOfElement(element);
        //Thread.sleep(500);
        element.sendKeys(value);

    }

    public static void click_button(WebElement element) throws InterruptedException {
        waitUtils.waitForElementClickable(element);
        //Thread.sleep(500);
        element.click();
    }
}
