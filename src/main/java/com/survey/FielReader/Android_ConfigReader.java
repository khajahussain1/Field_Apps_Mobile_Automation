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

    public static String Android_getAppiumServerurl() {
        String url = Android_ppty.getProperty("Android.appium.server.url");
        if(url!=null)
        {
            return url;

        }else{
            throw new RuntimeException("url not specified in the Configuration.properties file");
        }
    }

    public static String getString(String key) {
        return Android_ppty.getProperty(key);
    }

//    public static int getInt(String key) {
//        return Integer.parseInt(Android_ppty.getProperty(key));
//    }
    public static int getInt(String key) {
        String value = Android_ppty.getProperty(key);
        int result = value!=null?Integer.parseInt(value) : 0;
        return result;
    }

}