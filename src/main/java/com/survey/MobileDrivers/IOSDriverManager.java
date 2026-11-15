package com.survey.MobileDrivers;

import com.survey.DeviceConfig.IOSDeviceConfig;
import com.survey.DeviceManagers.IOSDeviceManager;
import com.survey.FielReader.IOS_ConfigReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static com.survey.FielReader.ConfigReader.ppty;
import static com.survey.MobileDrivers.AppiumDriverManager.setDriver;

public class IOSDriverManager {

    private static AppiumDriverLocalService service;

    public static AppiumDriver CreateIOSDriver() throws MalformedURLException {
//        service = new AppiumServiceBuilder().withIPAddress("127.0.0.1").usingPort(4724).withTimeout(Duration.ofSeconds(30)).build();
//        service.start();
        IOSDeviceConfig iosDeviceConfig = IOSDeviceManager.getInstance();
        String IOS_AppType = ppty.getProperty("appType");
        XCUITestOptions ios= new XCUITestOptions();
        switch(IOS_AppType.toUpperCase())
        {
            case "NATIVE":
                ios.setPlatformName(IOS_ConfigReader.IOS_getPlatformName());
                ios.setDeviceName(iosDeviceConfig.getDeviceName());
                ios.setAutomationName(IOS_ConfigReader.IOS_getAutomationName());
                ios.setPlatformVersion(IOS_ConfigReader.IOS_getPlatformVersion());
                ios.setApp(IOS_ConfigReader.IOS_getAppPath());
                ios.setUdid(iosDeviceConfig.getUdid());
                ios.setWdaLocalPort(iosDeviceConfig.getWdaLocalPort());
                ios.setDerivedDataPath(String.valueOf(iosDeviceConfig.getDerivedDataPath()));

//                ios.setWdaLocalPort(8101);
//                ios.setCapability("derivedDataPath", "/tmp/WDA_" + Thread.currentThread().getId());
//                ios.setCapability("useNewWDA", true);
//                .setWdaLocalPort(device.wdaLocalPort())
//                    .setDerivedDataPath(device.derivedDataPath());

//                options.setBundleId("com.demo.ios");
//                options.setNoReset(true);
              //  options.setFullReset(true);
                break;

            case "HYBRIDE":

                //platform capabilities
                ios.setPlatformName(IOS_ConfigReader.IOS_getPlatformName());
                ios.setDeviceName(IOS_ConfigReader.IOS_getDeviceName());
                ios.setAutomationName(IOS_ConfigReader.IOS_getAutomationName());
                ios.setPlatformVersion(IOS_ConfigReader.IOS_getPlatformVersion());
                ios.setApp(IOS_ConfigReader.IOS_getAppPath());

                //app capabilities
                ios.setBundleId("com.demo.ios");
                ios.setNoReset(true);
                ios.setFullReset(false);
                break;

            case "WEBAPP":
                ios.setPlatformName(IOS_ConfigReader.IOS_getPlatformName());
                ios.setDeviceName(IOS_ConfigReader.IOS_getDeviceName());
                ios.setAutomationName(IOS_ConfigReader.IOS_getAutomationName());
                ios.setPlatformVersion(IOS_ConfigReader.IOS_getPlatformVersion());
                ios.setUdid("emulator-5554");
                ios.setCapability("browserName", "chrome");
//                 return new AndroidDriver(new URL(ConfigReader.getAppiumServerurl()), options);
//                 getDriver().get("https://www.google.com");
                break;

            default:
                throw new RuntimeException("Platform not supported");
        }
        AppiumDriver iosDriver = new IOSDriver(new URL(IOS_ConfigReader.IOS_getAppiumServerurl()), ios);
        iosDriver.manage().timeouts().implicitlyWait(Duration.ZERO);
        System.out.println("IOS Session = " + iosDriver.getSessionId());
        setDriver(iosDriver);
        System.out.println("iosDriver :"+iosDriver);
        return iosDriver;

    }
}
