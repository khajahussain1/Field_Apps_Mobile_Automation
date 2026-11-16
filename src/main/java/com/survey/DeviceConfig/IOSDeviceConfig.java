package com.survey.DeviceConfig;

public class IOSDeviceConfig {

    private String platformName;
    private String automationName;
    private String platformVersion;
    private String appPath;
    private String deviceName;
    private String udid;
    private int wdaLocalPort;
    private String derivedDataPath;

    public IOSDeviceConfig(
            String platformName,
            String automationName,
            String platformVersion,
            String appPath,
            String deviceName,
            String udid,
            int wdaLocalPort,
            String derivedDataPath) {

        this.platformName = platformName;
        this.automationName = automationName;
        this.platformVersion = platformVersion;
        this.appPath = appPath;
        this.deviceName = deviceName;
        this.udid = udid;
        this.wdaLocalPort = wdaLocalPort;
        this.derivedDataPath = derivedDataPath;
    }



    // Getters

    public String getPlatformName() {
        return platformName;
    }

    public String getAutomationName() {
        return automationName;
    }

    public String getPlatformVersion() {
        return platformVersion;
    }

    public String getAppPath() {
        return appPath;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getUdid() {
        return udid;
    }

    public int getWdaLocalPort() {
        return wdaLocalPort;
    }

    public String getDerivedDataPath() {
        return derivedDataPath;
    }

    // Setters

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public void setAutomationName(String automationName) {
        this.automationName = automationName;
    }

    public void setPlatformVersion(String platformVersion) {
        this.platformVersion = platformVersion;
    }

    public void setAppPath(String appPath) {
        this.appPath = appPath;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public void setUdid(String udid) {
        this.udid = udid;
    }

    public void setWdaLocalPort(int wdaLocalPort) {
        this.wdaLocalPort = wdaLocalPort;
    }

    public void setDerivedDataPath(String derivedDataPath) {
        this.derivedDataPath = derivedDataPath;
    }
}