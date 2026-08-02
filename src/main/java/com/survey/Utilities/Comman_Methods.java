package com.survey.Utilities;

import io.appium.java_client.TouchAction;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.apache.log4j.Logger;

import static com.survey.Utilities.AppiumDriverInitialization.getDriver;

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

    public static void click_drop_down(WebElement element)
    {
        waitUtils.waitForElementClickable(element);
        element.click();

           }
}
