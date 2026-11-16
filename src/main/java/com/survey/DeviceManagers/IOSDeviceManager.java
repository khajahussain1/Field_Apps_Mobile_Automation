package com.survey.DeviceManagers;



import com.survey.DeviceConfig.IOSDeviceConfig;
import com.survey.FielReader.IOS_ConfigReader;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class IOSDeviceManager {

    private static final AtomicInteger COUNTER = new AtomicInteger(0);
    private static final List<IOSDeviceConfig> DEVICES = loadDevices();
    private static List<IOSDeviceConfig> loadDevices() {
        int count = IOS_ConfigReader.getInt("IOS.devicesCount");
        List<IOSDeviceConfig> IOSdevices = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            IOSdevices.add(new IOSDeviceConfig(
                    IOS_ConfigReader.getString("IOS" + i + ".platformName"),
                    IOS_ConfigReader.getString("IOS" + i + ".automationName"),
                    IOS_ConfigReader.getString("IOS" + i + ".platformVersion"),
                    IOS_ConfigReader.getString("IOS" + i + ".appPath"),
                    IOS_ConfigReader.getString("IOS" + i + ".deviceName"),
                    IOS_ConfigReader.getString("IOS" + i + ".udid"),
                    IOS_ConfigReader.getInt("IOS" + i + ".wdaLocalPort"),
                    IOS_ConfigReader.getString("IOS" + i + ".derivedDataPath")));
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
