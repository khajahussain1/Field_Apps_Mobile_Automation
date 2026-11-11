package com.survey.FielReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ConfigReader {
private static final String CONFIG_FILE_PATH = "src/main/resources/survey_config.properties";
public static Properties ppty;

static{
    ppty = new Properties();
    try(FileInputStream fis = new FileInputStream(CONFIG_FILE_PATH)){
        ppty.load(fis);

    } catch (IOException e) {
        e.printStackTrace();
    }
}

/*public static String getProperty(String key){
    String value = properties.getProperty(key);
    if(value==null){
        throw new RuntimeException("Property not found: "+key);
    }
    return value;

}*/

public static int getIntProperty(String key, int defaultValue)
{
    String value = ppty.getProperty(key);
    return value!=null?Integer.parseInt(value) : defaultValue;
}

    public static boolean getBooleanProperty(String key, Boolean defaultValue)
    {
        String value = ppty.getProperty(key);
        return value!=null?Boolean.parseBoolean(value) : defaultValue;
    }

public static String getAndroidAppFilePath(){
    return ppty.getProperty("android.survey_appFilePath");
}

    public static String getIOSAppFilePath(){
        return ppty.getProperty("ios.appFilePath");
    }

    public static String getPlatformName() {return ppty.getProperty("platformName");
    }

    public static String getAutomationName() {return ppty.getProperty("automationName");
    }

    public static String getPlatformVersion() {return ppty.getProperty("platformVersion");
    }

    public static String getDeviceName() {return ppty.getProperty("deviceName");
    }

    public static String getAppPath() {
        String AppPath = System.getProperty("user.dir")+ppty.getProperty("appPath");
        System.out.println("APK Path: " + AppPath);
        File apk = new File(AppPath);
        System.out.println("Exists: " + apk.exists());
        if(AppPath!=null)
        {
            return AppPath;

        }else{
            throw new RuntimeException("App Path not specified in the Configuration.properties file");
        }
    }

    public static String getAppPackage() {return ppty.getProperty("app.package");
    }

    public static String getAppActivity() {return ppty.getProperty("app.activity");
    }

    public static boolean isNoReset() {return getBooleanProperty("no.reset", false);
    }

    public static int getNewCommandTimeout() {return getIntProperty("timeout.new.command", 600);
    }

//    public static String getAppiumServerurl() {
//    return ppty.getProperty("appium.server.url");
//    }

    public static String getAppiumServerurl() {
        String url = ppty.getProperty("appium.server.url");
        if(url!=null)
        {
            return url;

        }else{
            throw new RuntimeException("url not specified in the Configuration.properties file");
        }
    }

    public String getProperty(String key, String defultValue){
        return ppty.getProperty(key,defultValue);
    }

//    public static int getIntProperty(String key){
//        return Integer.parseInt(getProperty(key));
//    }

}