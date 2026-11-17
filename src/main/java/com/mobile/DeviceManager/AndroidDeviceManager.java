package com.mobile.DeviceManager;

import com.mobile.DeviceConfig.AndroidDeviceConfig;
import com.mobile.ConfigReader.AndroidConfigReader;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AndroidDeviceManager {

    private static final AtomicInteger COUNTER = new AtomicInteger(0);
    private static final List<AndroidDeviceConfig> DEVICES = loadDevices();

    private static List<AndroidDeviceConfig> loadDevices() {
        int count = AndroidConfigReader.getInt("Android.devicesCount");
        List<AndroidDeviceConfig> devices = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            devices.add(new AndroidDeviceConfig(
                    AndroidConfigReader.getString("Android" + i + ".platformName"),
                    AndroidConfigReader.getString("Android" + i + ".automationName"),
                    AndroidConfigReader.getString("Android" + i + ".platformVersion"),
                    AndroidConfigReader.getString("Android" + i + ".appPath"),
                    AndroidConfigReader.getString("Android" + i + ".appPackage"),
                    AndroidConfigReader.getString("Android" + i + ".appActivity"),
                    AndroidConfigReader.getString("Android" + i + ".deviceName"),
                    AndroidConfigReader.getString("Android" + i + ".udid"),
                    AndroidConfigReader.getInt("Android" + i + ".systemPort"),
                    AndroidConfigReader.getInt("Android" + i + ".chromeDriverPort"),
                    AndroidConfigReader.getInt("Android" + i + ".mjpegServerPort")));
        }

        return devices;
    }

    private static final ThreadLocal<AndroidDeviceConfig> DEVICE = ThreadLocal.withInitial(() -> {
                int index = COUNTER.getAndIncrement() % DEVICES.size();
                //return DEVICES.get(index);
        AndroidDeviceConfig device = DEVICES.get(index);
        System.out.println("Thread: " + Thread.currentThread().getId() + " -> " + device.getDeviceName() + " -> " + device.getUdid());

        return device;
            });


    public static AndroidDeviceConfig getInstance() {
        return DEVICE.get();
    }
}
