package com.survey.Utilities;

import com.survey.FielReader.ConfigReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.java.Scenario;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static com.survey.FielReader.ConfigReader.ppty;

public class AppiumDriverManager {

    public static AppiumDriverLocalService service;
    public static AppiumDriver driver;
    private static final ThreadLocal<AppiumDriver> TLDriver = new ThreadLocal<>();
    public static Scenario scenario;

    public static void InitializeDriver() throws MalformedURLException {
        service = new AppiumServiceBuilder().withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(30)).build();
        service.start();
        System.out.println("Appium Server Started Successfully");
        String platform = ppty.getProperty("PLATFORM");
        String appType = ppty.getProperty("appType");
        switch (platform.toLowerCase())
        {
         case "android":
             createAndroidDriver(appType);
             break;

             case "ios":
                 CreateIOSDriver(appType);
                 break;

            default:
                throw new RuntimeException("Platform not supported");
        }
        setDriver(driver);
    }

    public static AppiumDriver createAndroidDriver(String appType) throws MalformedURLException {
        UiAutomator2Options options= new UiAutomator2Options();
        switch(appType.toUpperCase())
        {
            case "NATIVE":
            //platform capabilities
            options.setPlatformName(ConfigReader.getPlatformName());
            options.setDeviceName(ConfigReader.getDeviceName());
            options.setAutomationName(ConfigReader.getAutomationName());
            options.setPlatformVersion(ConfigReader.getPlatformVersion());
            options.setApp(ConfigReader.getAppPath());

            //app capabilities
            options.setAppPackage(ConfigReader.getAppPackage());
            options.setAppActivity(ConfigReader.getAppActivity());
            options.setNoReset(true);
            options.setFullReset(false);
            break;

            case "HYBRIDE":

                //platform capabilities
                options.setPlatformName(ConfigReader.getPlatformName());
                options.setDeviceName(ConfigReader.getDeviceName());
                options.setAutomationName(ConfigReader.getAutomationName());
                options.setPlatformVersion(ConfigReader.getPlatformVersion());
                options.setApp(ConfigReader.getAppPath());

                //app capabilities
                options.setAppPackage(ConfigReader.getAppPackage());
                options.setAppActivity(ConfigReader.getAppActivity());
                options.setNoReset(true);
                options.setFullReset(false);
                break;

            case "WEBAPP":
                 options.setPlatformName(ConfigReader.getPlatformName());
                 options.setDeviceName(ConfigReader.getDeviceName());
                 options.setAutomationName(ConfigReader.getAutomationName());
                 options.setPlatformVersion(ConfigReader.getPlatformVersion());
                 options.setUdid("emulator-5554");
                 options.setCapability("browserName", "chrome");
//                 return new AndroidDriver(new URL(ConfigReader.getAppiumServerurl()), options);
//                 getDriver().get("https://www.google.com");
                break;

            default:
                throw new RuntimeException("Platform not supported");
        }
        return new AndroidDriver(new URL(ConfigReader.getAppiumServerurl()), options);
    }

      public static AppiumDriver CreateIOSDriver(String appType) throws MalformedURLException {
        XCUITestOptions options= new XCUITestOptions();
        switch(appType.toUpperCase())
        {
            case "NATIVE":
                //platform capabilities
                options.setPlatformName(ConfigReader.getPlatformName());
                options.setDeviceName(ConfigReader.getDeviceName());
                options.setAutomationName(ConfigReader.getAutomationName());
                options.setPlatformVersion(ConfigReader.getPlatformVersion());
                //options.setApp(ConfigReader.getAppPath());
                options.setApp("/Users/poolakhajahussain/Downloads/iOS.Simulator.app");


                //app capabilities
                options.setUdid("8DA3E842-99BC-4C89-B6CD-03F424439B82");

//                options.setBundleId("com.demo.ios");
//                options.setNoReset(true);
//                options.setFullReset(false);
                break;

            case "HYBRIDE":

                //platform capabilities
                options.setPlatformName(ConfigReader.getPlatformName());
                options.setDeviceName(ConfigReader.getDeviceName());
                options.setAutomationName(ConfigReader.getAutomationName());
                options.setPlatformVersion(ConfigReader.getPlatformVersion());
                options.setApp(ConfigReader.getAppPath());

                //app capabilities
                options.setBundleId("com.demo.ios");
                options.setNoReset(true);
                options.setFullReset(false);
                break;

            case "WEBAPP":
                options.setPlatformName(ConfigReader.getPlatformName());
                options.setDeviceName(ConfigReader.getDeviceName());
                options.setAutomationName(ConfigReader.getAutomationName());
                options.setPlatformVersion(ConfigReader.getPlatformVersion());
                options.setUdid("emulator-5554");
                options.setCapability("browserName", "chrome");
//                 return new AndroidDriver(new URL(ConfigReader.getAppiumServerurl()), options);
//                 getDriver().get("https://www.google.com");
                break;

            default:
                throw new RuntimeException("Platform not supported");
        }
          return driver = new IOSDriver(new URL(ConfigReader.getAppiumServerurl()), options);
        //return new IOSDriver(new URL(ConfigReader.getAppiumServerurl()), options);
    }


        public static AppiumDriver getDriver()
        {
            return TLDriver.get();
        }

    public static void setDriver(AppiumDriver driver)
    {
        TLDriver.set(driver);
    }

    public static void quitDriver()
    {
        TLDriver.get().quit();
        TLDriver.remove();
    }
    }

