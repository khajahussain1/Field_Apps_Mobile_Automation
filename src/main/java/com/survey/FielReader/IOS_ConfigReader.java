package com.survey.FielReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class IOS_ConfigReader {
private static final String CONFIG_FILE_PATH = "src/test/resources/device_properties/ios_device.properties";
public static Properties IOS_ppty;

static{
    IOS_ppty = new Properties();
    try(FileInputStream fis = new FileInputStream(CONFIG_FILE_PATH)){
        IOS_ppty.load(fis);

    } catch (IOException e) {
        throw new RuntimeException("Unable to load config file", e);
    }
}

public static int getIntProperty(String key, int defaultValue)
{
    String value = IOS_ppty.getProperty(key);
    return value!=null?Integer.parseInt(value) : defaultValue;
}

    public static boolean getBooleanProperty(String key, Boolean defaultValue)
    {
        String value = IOS_ppty.getProperty(key);
        return value!=null?Boolean.parseBoolean(value) : defaultValue;
    }

    public static String IOS_getPlatformName() {return IOS_ppty.getProperty("IOS.PlatformName");
    }

    public static String IOS_getAutomationName() {return IOS_ppty.getProperty("IOS.AutomationName");
    }

    public static String IOS_getPlatformVersion() {return IOS_ppty.getProperty("IOS.PlatformVersion");
    }

    public static String IOS_getDeviceName() {return IOS_ppty.getProperty("IOS.DeviceName");
    }

    public static String IOS_getAppPath() {
        String AppPath = System.getProperty("user.dir")+IOS_ppty.getProperty("IOS.AppPath");
        System.out.println("APP Path: " + AppPath);
        File apk = new File(AppPath);
        System.out.println("Exists: " + apk.exists());
        if(AppPath!=null)
        {
            return AppPath;

        }else{
            throw new RuntimeException("App Path not specified in the Configuration.properties file");
        }
    }

    public static boolean isNoReset() {return getBooleanProperty("no.reset", false);
    }

    public static int getNewCommandTimeout() {return getIntProperty("timeout.new.command", 600);
    }

    public static String IOS_getAppiumServerurl() {
        return IOS_ppty.getProperty("IOS.appium.server.url");
    }

    public static String getStringValue(String key) {
        return IOS_ppty.getProperty(key);
    }

    public static int getIntValue(String key) {
        String value = IOS_ppty.getProperty(key);
        int result = value!=null?Integer.parseInt(value) : 0;
        return result;
    }

}