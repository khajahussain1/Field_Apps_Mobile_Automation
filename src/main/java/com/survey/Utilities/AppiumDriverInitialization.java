package com.survey.Utilities;

import com.survey.FielReader.ConfigReader;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Scenario;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriverInitialization {

    private static final ThreadLocal<AndroidDriver> driverThreadLocal = new ThreadLocal<>();
    public static Scenario scenario;

    public static AndroidDriver initDriver(){
        if(driverThreadLocal.get() == null) {
            AndroidDriver driver = null;
            Exception lastException = null;
            int maxAttempts = 2;
            for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                try {

                    driver = createDriver();
                    break;
                } catch (Exception e) {
                    if (attempt < maxAttempts) {
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }

                    }

                }

            }

            if (driver == null) {
                throw new RuntimeException("Fialed to create Appium session after "+maxAttempts+"attemps. "+"Make sure no stale Appium session is active. Last error: "+(lastException!=null?lastException.getMessage():"unknow"), lastException);
            }
            driverThreadLocal.set(driver);
        }
            return driverThreadLocal.get();
        }

        public static AndroidDriver getDriver(){
            AndroidDriver driver = driverThreadLocal.get();
            if(driver == null){
                throw new IllegalStateException("driver is not initialized call initDriver() first");
            }
            return driver;
        }

        public static boolean isDriverInitialized(){
            return driverThreadLocal.get()!=null;
        }

        public static void quitDriver(){
            AndroidDriver driver = driverThreadLocal.get();
            if(driver!= null){
                try{
                    driver.quit();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }finally {
                    driverThreadLocal.remove();
                }
            }
        }
        private static AndroidDriver createDriver(){
            DesiredCapabilities caps = new DesiredCapabilities();

            //Platform caps
            caps.setCapability("platformName", ConfigReader.getPlatformName());
            caps.setCapability("appium:automationName", ConfigReader.getAutomationName());
            caps.setCapability("appium:platformVersion", ConfigReader.getPlatformVersion());
            caps.setCapability("appium:deviceName", ConfigReader.getDeviceName());
            caps.setCapability("appium:app", ConfigReader.getAppPath());

            //App capabilities
            caps.setCapability("appium:appPackage", ConfigReader.getAppPackage());
            caps.setCapability("appium:appActivity", ConfigReader.getAppActivity());
            caps.setCapability("appium:noReset", ConfigReader.isNoReset());

            //Timeout capabilities
            caps.setCapability("appium:newCommandTimeout", ConfigReader.getNewCommandTimeout());
            caps.setCapability("appium:adbExecTimeout", 60000);
            caps.setCapability("appium:uiautomator2ServerLaunchTimeout", ConfigReader.getIntProperty("timeout.uiautomator2.launch", 60000));
            caps.setCapability("appium:uiautomator2ServerInstallTimeout", ConfigReader.getIntProperty("timeout.uiautomator2.install", 60000));

            try {
                return new AndroidDriver(new URL(ConfigReader.getAppiumServerurl()), caps);
            } catch (MalformedURLException e) {
                throw new RuntimeException("Invalid Appium server URL: " + ConfigReader.getAppiumServerurl(), e);

            }
        }
    }

