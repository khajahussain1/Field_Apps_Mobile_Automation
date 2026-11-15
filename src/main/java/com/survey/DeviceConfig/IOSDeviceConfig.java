package com.survey.DeviceConfig;


public class IOSDeviceConfig {
    private final String deviceName;
    private final String udid;
    private final int WdaLocalPort;
    private final String DerivedDataPath;


    public IOSDeviceConfig(String deviceName, String udid, int WdaLocalPort, String DerivedDataPath) {
        this.deviceName = deviceName;
        this.udid = udid;
        this.WdaLocalPort = WdaLocalPort;
        this.DerivedDataPath = DerivedDataPath;

    }

    public String getDeviceName() {
        return deviceName;
    }
    public String getUdid() {
        return udid;
    }
    public int getWdaLocalPort() {
        return WdaLocalPort;
    }
    public String getDerivedDataPath() {
        return DerivedDataPath;
    }

}
