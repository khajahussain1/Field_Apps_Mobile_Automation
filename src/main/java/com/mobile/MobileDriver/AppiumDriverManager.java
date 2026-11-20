package com.mobile.MobileDriver;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.Scenario;

import java.net.MalformedURLException;

import static com.mobile.ConfigReader.ConfigReader.ppty;

public class AppiumDriverManager {

    //    public static AppiumDriverLocalService service;
    private static final ThreadLocal<AppiumDriver> TLDriver = new ThreadLocal<>();
    public static Scenario scenario;

    public static AppiumDriver InitializeDriver(String platform) throws MalformedURLException {
        if(platform.toUpperCase().equalsIgnoreCase("ANDROID")) {
            return AndroidDriverManager.createAndroidDriver();

        }
        if(platform.toUpperCase().equalsIgnoreCase("IOS")) {
            return IOSDriverManager.CreateIOSDriver();
        }

        throw new RuntimeException("Platform not supported");
    }

   /* public static AppiumDriver InitializeDriver() throws MalformedURLException {
//        service = new AppiumServiceBuilder().withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(30)).build();
//        service.start();
        String platform = ppty.getProperty("PLATFORM");
        switch (platform.toUpperCase()) {
            case "ANDROID":
                AndroidDriverManager.createAndroidDriver();
                break;

            case "IOS":
                IOSDriverManager.CreateIOSDriver();
                break;

            case "ANDROID_IOS":
                IOSDriverManager.CreateIOSDriver();
                AndroidDriverManager.createAndroidDriver();
                break;

            default:
                throw new RuntimeException("Platform not supported");
        }
        return getDriver();
    }
*/
    public static AppiumDriver getDriver() {
        AppiumDriver driver = TLDriver.get();
        if (driver == null) {
            throw new RuntimeException("Driver not initialized");
        }
        return TLDriver.get();
    }

    public static void setDriver(AppiumDriver appiumDriver) {
        TLDriver.set(appiumDriver);
    }

    public static void quitDriver() {
        AppiumDriver driver = TLDriver.get();
        try {
            if (driver != null)
                driver.quit();
        } finally {
            TLDriver.remove();
        }
    }

}