package com.mobile.MobileDriver;

import com.mobile.DeviceManager.AndroidDeviceManager;
import com.mobile.ConfigReader.AndroidConfigReader;
import com.mobile.DeviceConfig.AndroidDeviceConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static com.mobile.ConfigReader.ConfigReader.ppty;
import static com.mobile.MobileDriver.AppiumDriverManager.setDriver;

public class AndroidDriverManager {
    private static AppiumDriverLocalService service;

    public static AppiumDriver createAndroidDriver() throws MalformedURLException {
//        service = new AppiumServiceBuilder().withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(30)).build();
//        service.start();
        AndroidDeviceConfig deviceConfig = AndroidDeviceManager.getInstance();
        String Android_AppType = ppty.getProperty("appType");
        UiAutomator2Options android= new UiAutomator2Options();
        switch(Android_AppType.toUpperCase())
        {
            case "NATIVE":
                android.setPlatformName(deviceConfig.getPlatformName());
                android.setDeviceName(deviceConfig.getDeviceName());
                android.setAutomationName(deviceConfig.getAutomationName());
                android.setPlatformVersion(deviceConfig.getPlatformVersion());
                android.setUdid(deviceConfig.getUdid());
                android.setSystemPort(deviceConfig.getSystemPort());
                android.setChromedriverPort(deviceConfig.getChromeDriverPort());
                android.setMjpegServerPort(deviceConfig.getMjpegServerPort());
                android.setApp(System.getProperty("user.dir")+deviceConfig.getAppPath());
                android.setAppPackage(deviceConfig.getAppPackage());
                android.setAppActivity(deviceConfig.getAppActivity());
                android.setNoReset(false);
                android.setFullReset(true);
                System.out.println("Driver started"+deviceConfig.getDeviceName());
                break;

            case "HYBRIDE":
                android.setPlatformName(deviceConfig.getPlatformName());
                android.setDeviceName(deviceConfig.getDeviceName());
                android.setAutomationName(deviceConfig.getAutomationName());
                //android.setPlatformVersion(deviceConfig.getPlatformVersion());
                android.setUdid(deviceConfig.getUdid());
                android.setSystemPort(deviceConfig.getSystemPort());
                android.setChromedriverPort(deviceConfig.getChromeDriverPort());
                android.setMjpegServerPort(deviceConfig.getMjpegServerPort());
                android.setApp(deviceConfig.getAppPath());
                android.setAppPackage(deviceConfig.getAppPackage());
                android.setAppActivity(deviceConfig.getAppActivity());
                android.setNoReset(false);
                android.setFullReset(true);
                System.out.println("Driver started"+deviceConfig.getDeviceName());
                break;

            case "WEBAPP":
                android.setPlatformName(deviceConfig.getPlatformName());
                android.setDeviceName(deviceConfig.getDeviceName());
                android.setAutomationName(deviceConfig.getAutomationName());
                //android.setPlatformVersion(deviceConfig.getPlatformVersion());
                android.setUdid("emulator-5554");
                android.setCapability("browserName", "chrome");
//                 return new AndroidDriver(new URL(ConfigReader.getAppiumServerurl()), options);
//                 getDriver().get("https://www.google.com");
                break;

            default:
                throw new RuntimeException("Platform not supported");
        }
        AppiumDriver androidDriver= new AndroidDriver(new URL(AndroidConfigReader.Android_getAppiumServerurl()), android);
        androidDriver.manage().timeouts().implicitlyWait(Duration.ZERO);
        setDriver(androidDriver);
        System.out.println("ANDROID Session = " + androidDriver.getSessionId());
        System.out.println("ANDROID driver :"+androidDriver);
        return androidDriver;
    }
}
