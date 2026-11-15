package com.survey.DeviceConfig;

public class AndroidDeviceConfig {
    private final String deviceName;
    private final String udid;
    private final int systemPort;
    private final int chromeDriverPort;
    private final int mjpegServerPort;

    public AndroidDeviceConfig(String deviceName, String udid, int systemPort, int chromeDriverPort, int mjpegServerPort) {
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
    public int getChromeDriverPort() {
        return chromeDriverPort;
    }
    public int getMjpegServerPort() {
        return mjpegServerPort;
    }

}
