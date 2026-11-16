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

    public static String IOS_getAppiumServerurl() {
        return IOS_ppty.getProperty("IOS.appium.server.url");
    }

    public static String getString(String key) {
        return IOS_ppty.getProperty(key);
    }

    public static int getInt(String key) {
        String value = IOS_ppty.getProperty(key);
        int result = value!=null?Integer.parseInt(value) : 0;
        return result;
    }

}