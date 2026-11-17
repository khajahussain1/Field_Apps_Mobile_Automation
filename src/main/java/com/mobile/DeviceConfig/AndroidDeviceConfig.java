package com.mobile.DeviceConfig;


public class AndroidDeviceConfig {
    private final String platformName;
    private final String automationName;
    private final String platformVersion;
    private final String appPath;
    private final String appPackage;
    private final String appActivity;
    private final String deviceName;
    private final String udid;
    private final int systemPort;
    private final int chromeDriverPort;
    private final int mjpegServerPort;

    public AndroidDeviceConfig(String platformName, String automationName, String platformVersion, String appPath, String appPackage, String appActivity, String deviceName, String udid, int systemPort, int chromeDriverPort, int mjpegServerPort) {
        this.platformName = platformName;
        this.automationName = automationName;
        this.platformVersion = platformVersion;
        this.appPath = appPath;
        this.appPackage = appPackage;
        this.appActivity = appActivity;
        this.deviceName = deviceName;
        this.udid = udid;
        this.systemPort = systemPort;
        this.chromeDriverPort = chromeDriverPort;
        this.mjpegServerPort = mjpegServerPort;
    }

    public String getDeviceName() {
        return deviceName;
    }
    public String getUdid() {

        return udid;
    }
    public int getSystemPort() {
        return systemPort;
    }
    public String getPlatformVersion() {
        return platformVersion;
    }
    public int getChromeDriverPort() {
        return chromeDriverPort;
    }
    public int getMjpegServerPort() {
        return mjpegServerPort;
    }
    public String getPlatformName() {
        return platformName;
    }
    public String getAutomationName() {
        return automationName;
    }

    public String getAppPath() {
        return appPath;
    }
    public String getAppPackage() {
        return appPackage;
    }
    public String getAppActivity() {
        return appActivity;
    }
}
