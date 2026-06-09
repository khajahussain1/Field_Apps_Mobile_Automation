package com.survey.Utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.survey.Utilities.AppiumDriverInitialization.getDriver;

public class Comman_Methods {
    protected static void actionInit() {
    }

    protected static void javascriptInit() {
    }

    public static byte[] embedScreenshot(){
        byte[] srcBytes = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
        return srcBytes;
    }
}
