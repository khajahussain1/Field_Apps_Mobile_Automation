package com.mobile.DeviceManager;



import com.mobile.DeviceConfig.IOSDeviceConfig;
import com.mobile.ConfigReader.IOSConfigReader;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class IOSDeviceManager {

    private static final AtomicInteger COUNTER = new AtomicInteger(0);
    private static final List<IOSDeviceConfig> DEVICES = loadDevices();
    private static List<IOSDeviceConfig> loadDevices() {
        int count = IOSConfigReader.getInt("IOS.devicesCount");
        List<IOSDeviceConfig> IOSdevices = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            IOSdevices.add(new IOSDeviceConfig(
                    IOSConfigReader.getString("IOS" + i + ".platformName"),
                    IOSConfigReader.getString("IOS" + i + ".automationName"),
                    IOSConfigReader.getString("IOS" + i + ".platformVersion"),
                    IOSConfigReader.getString("IOS" + i + ".appPath"),
                    IOSConfigReader.getString("IOS" + i + ".deviceName"),
                    IOSConfigReader.getString("IOS" + i + ".udid"),
                    IOSConfigReader.getInt("IOS" + i + ".wdaLocalPort"),
                    IOSConfigReader.getString("IOS" + i + ".derivedDataPath")));
        }

        return IOSdevices;
    }

    private static final ThreadLocal<IOSDeviceConfig> DEVICE =
            ThreadLocal.withInitial(() -> {
                int index = COUNTER.getAndIncrement() % DEVICES.size();
                IOSDeviceConfig ios_device = DEVICES.get(index);

                System.out.println("============== IOS DEVICE ==============");
                System.out.println("Platform Name    : " + ios_device.getPlatformName());
                System.out.println("Automation Name  : " + ios_device.getAutomationName());
                System.out.println("Platform Version : " + ios_device.getPlatformVersion());
                System.out.println("Device Name      : " + ios_device.getDeviceName());
                System.out.println("UDID             : " + ios_device.getUdid());
                System.out.println("WDA Port         : " + ios_device.getWdaLocalPort());
                System.out.println("DerivedDataPath  : " + ios_device.getDerivedDataPath());
                System.out.println("========================================");

                System.out.println("IOS Thread : " + Thread.currentThread().getId() + " -> " + ios_device.getDeviceName() + " -> " + ios_device.getUdid());

                return ios_device;
            });

    public static IOSDeviceConfig getInstance() {
        return DEVICE.get();
    }
}
