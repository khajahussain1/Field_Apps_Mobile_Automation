package com.survey.DeviceManagers;


import com.survey.DeviceConfig.IOSDeviceConfig;
import com.survey.FielReader.IOS_ConfigReader;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class IOSDeviceManager {

    private static final AtomicInteger COUNTER = new AtomicInteger(0);
    private static final ThreadLocal<IOSDeviceConfig> DEVICE = ThreadLocal.withInitial(() -> {
        List<IOSDeviceConfig> devices = Arrays.asList(
                new IOSDeviceConfig(
                        IOS_ConfigReader.getStringValue("IOS1.DeviceName"),
                        IOS_ConfigReader.getStringValue("IOS1.UDID"),
                        IOS_ConfigReader.getIntValue("IOS1.WdaLocalPort"),
                        IOS_ConfigReader.getStringValue("IOS1.DerivedDataPath")),

                new IOSDeviceConfig(
                        IOS_ConfigReader.getStringValue("IOS2.DeviceName"),
                        IOS_ConfigReader.getStringValue("IOS2.UDID"),
                        IOS_ConfigReader.getIntValue("IOS2.WdaLocalPort"),
                        IOS_ConfigReader.getStringValue("IOS2.DerivedDataPath")));

        int index = COUNTER.getAndIncrement() % devices.size();
        return devices.get(index);
    });

    public  static IOSDeviceConfig getInstance(){
        return DEVICE.get();
    }

}
