package com.survey.FielReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Android_ConfigReader {
private static final String CONFIG_FILE_PATH = "src/test/resources/device_properties/android_device.properties";
public static Properties Android_ppty;

static{
    Android_ppty = new Properties();
    try(FileInputStream fis = new FileInputStream(CONFIG_FILE_PATH)){
        Android_ppty.load(fis);

    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public static String Android_getPlatformName() { return Android_ppty.getProperty("Android.PlatformName");
    }

    public static String Android_getAutomationName() {return Android_ppty.getProperty("Android.AutomationName");
    }

    public static String Android_getPlatformVersion() {return Android_ppty.getProperty("Android.PlatformVersion");
    }

    public static String Android_getDeviceName() {return Android_ppty.getProperty("Android.DeviceName");
    }
    public static String Android_getAppPath() {
        String AndroidAppPath = System.getProperty("user.dir")+Android_ppty.getProperty("Android.AppPath");
        System.out.println("APK Path: " + AndroidAppPath);
        File apk = new File(AndroidAppPath);
        System.out.println("Exists: " + apk.exists());
        if(AndroidAppPath!=null)
        {
            return AndroidAppPath;

        }else{
            throw new RuntimeException("App Path not specified in the Configuration.properties file");
        }
    }


    public static String Android_getAppPackage() {return Android_ppty.getProperty("Android.AppPackage");
    }

    public static String Android_getAppActivity() {return Android_ppty.getProperty("Android.AppActivity");
    }

    public static String Android_getAppiumServerurl() {
        String url = Android_ppty.getProperty("Android.appium.server.url");
        if(url!=null)
        {
            return url;

        }else{
            throw new RuntimeException("url not specified in the Configuration.properties file");
        }
    }

}