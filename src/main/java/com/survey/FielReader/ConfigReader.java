package com.survey.FielReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static jdk.internal.net.http.common.Utils.getBooleanProperty;

public class ConfigReader {
private static final String CONFIG_FILE_PATH = "src/main/resources/survey_config.properties";
private static Properties properties;

static{
    properties = new Properties();
    try(FileInputStream fis = new FileInputStream(CONFIG_FILE_PATH)){
        properties.load(fis);

    } catch (IOException e) {
        e.printStackTrace();
    }
}

public static String getProperty(String key){
    String value = properties.getProperty(key);
    if(value==null){
        throw new RuntimeException("Property not found: "+key);
    }
    return value;

}

public static String getAndroidAppFilePath(){
    return properties.getProperty("android.survey_appFilePath");
}

    public static String getIOSAppFilePath(){
        return properties.getProperty("ios.appFilePath");
    }

    public static String getPlatformName() {return properties.getProperty("platform.name");
    }

    public static String getAutomationName() {return properties.getProperty("automation.name");
    }

    public static String getPlatformVersion() {return properties.getProperty("platform.version");
    }

    public static String getDeviceName() {return properties.getProperty("device.name");
    }

    public static String getAppPath() {return System.getProperty("user.dir")+getProperty("app.path");
    }

    public static String getAppPackage() {return properties.getProperty("app.package");
    }

    public static String getAppActivity() {return properties.getProperty("app.activity");
    }

    public static boolean isNoReset() {return getBooleanProperty("no.reset", false);
    }

    public static int getNewCommandTimeout() {return getIntProperty("timeout.new.command", 600);
    }

    public static String getAppiumServerurl() {
    return properties.getProperty("appium.server.url");
    }

    public String getProperty(String key, String defultValue){
        return properties.getProperty(key,defultValue);
    }

    public static int getIntProperty(String key){
        return Integer.parseInt(getProperty(key));
    }

}
