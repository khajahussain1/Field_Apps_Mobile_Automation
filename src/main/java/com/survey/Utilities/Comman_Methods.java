package com.survey.Utilities;

import io.appium.java_client.AppiumBy;
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
        waitUtils.waitForElementClickable(element);
        element.click();

           }
    public static void enter_text(WebElement element, String value ) throws InterruptedException {
        WaitUtils.VisibilityOfElement(element);
        element.clear();
        element.sendKeys(value);

    }

    public static void click_button(WebElement element) throws InterruptedException {
        waitUtils.waitForElementClickable(element);
        element.click();
    }

    public static boolean isDisplayed_dropdown_menu(WebElement element) throws InterruptedException {
        try {
            WaitUtils.VisibilityOfElement(element);
            if (element.isDisplayed()) {
                return true;
            }
        }catch(Exception e)
        {
           System.out.println(e+" drop down menu is not displayed");
            //return false;
        }

        return false;
    }

    public static void click_dropdown_Domain(WebElement element) throws InterruptedException {
        waitUtils.waitForElementClickable(element);
        element.click();
    }

    public static void selectCountry(String CountryName)
    {
        getDriver().findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\""+CountryName+"\"))"));
        getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\""+CountryName+"\")")).click();
    }

}
