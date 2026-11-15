package com.survey.MobileDrivers;

import com.survey.DeviceManagers.AndroidDeviceManager;
import com.survey.FielReader.Android_ConfigReader;
import com.survey.DeviceConfig.AndroidDeviceConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static com.survey.FielReader.ConfigReader.ppty;
import static com.survey.MobileDrivers.AppiumDriverManager.setDriver;

public class AndroidDriverManager {
    private static AppiumDriverLocalService service;

    public static AppiumDriver createAndroidDriver() throws MalformedURLException {
//        service = new AppiumServiceBuilder().withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(30)).build();
//        service.start();
        String Android_AppType = ppty.getProperty("appType");
        AndroidDeviceConfig deviceConfig = AndroidDeviceManager.getInstance();
        UiAutomator2Options android= new UiAutomator2Options();
        switch(Android_AppType.toUpperCase())
        {
            case "NATIVE":
                //platform capabilities
                android.setPlatformName(Android_ConfigReader.Android_getPlatformName());
                android.setDeviceName(deviceConfig.getDeviceName());
                android.setAutomationName(Android_ConfigReader.Android_getAutomationName());
                android.setPlatformVersion(Android_ConfigReader.Android_getPlatformVersion());
                android.setUdid(deviceConfig.getUdid());
                android.setSystemPort(deviceConfig.getSystemPort());
                android.setChromedriverPort(deviceConfig.getChromeDriverPort());
                android.setMjpegServerPort(deviceConfig.getMjpegServerPort());
                android.setApp(Android_ConfigReader.Android_getAppPath());
                android.setAppPackage(Android_ConfigReader.Android_getAppPackage());
                android.setAppActivity(Android_ConfigReader.Android_getAppActivity());
                android.setNoReset(false);
                android.setFullReset(true);
                System.out.println("Driver started"+deviceConfig.getDeviceName());
                break;

            case "HYBRIDE":

                //platform capabilities
                android.setPlatformName(Android_ConfigReader.Android_getPlatformName());
                android.setDeviceName(Android_ConfigReader.Android_getDeviceName());
                android.setAutomationName(Android_ConfigReader.Android_getAutomationName());
                android.setPlatformVersion(Android_ConfigReader.Android_getPlatformVersion());
                android.setApp(Android_ConfigReader.Android_getAppPath());

                //app capabilities
                android.setAppPackage(Android_ConfigReader.Android_getAppPackage());
                android.setAppActivity(Android_ConfigReader.Android_getAppActivity());
                //android.setNoReset(true);
                android.setFullReset(true);
                break;

            case "WEBAPP":
                android.setPlatformName(Android_ConfigReader.Android_getPlatformName());
                android.setDeviceName(Android_ConfigReader.Android_getDeviceName());
                android.setAutomationName(Android_ConfigReader.Android_getAutomationName());
                android.setPlatformVersion(Android_ConfigReader.Android_getPlatformVersion());
                android.setUdid("emulator-5554");
                android.setCapability("browserName", "chrome");
//                 return new AndroidDriver(new URL(ConfigReader.getAppiumServerurl()), options);
//                 getDriver().get("https://www.google.com");
                break;

            default:
                throw new RuntimeException("Platform not supported");
        }
//        driver =  new AndroidDriver(new URL(ConfigReader.getAppiumServerurl()), options);
        AppiumDriver androidDriver= new AndroidDriver(new URL(Android_ConfigReader.Android_getAppiumServerurl()), android);
        androidDriver.manage().timeouts().implicitlyWait(Duration.ZERO);
        setDriver(androidDriver);
        System.out.println("ANDROID Session = " + androidDriver.getSessionId());
        System.out.println("ANDROID driver :"+androidDriver);
        return androidDriver;
    }
}
