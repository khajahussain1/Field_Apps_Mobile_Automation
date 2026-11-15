package com.survey.DeviceManagers;

import com.survey.DeviceConfig.AndroidDeviceConfig;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AndroidDeviceManager {

    private static final AtomicInteger COUNTER = new AtomicInteger(0);
    private static final ThreadLocal<AndroidDeviceConfig> DEVICE = ThreadLocal.withInitial(() -> {
        List<AndroidDeviceConfig> devices = Arrays.asList(
                new AndroidDeviceConfig(
                        "Pixel 10 Pro XL API 37.0",
                        "emulator-5554",
                        8201,
                        9515,
                        7810),
                new AndroidDeviceConfig(
                        "Small Phone API 37.0",
                        "emulator-5556",
                        8202,
                        9516,
                        7811));
        int index = COUNTER.getAndIncrement() % devices.size();
        return devices.get(index);
    });

    public  static AndroidDeviceConfig getInstance(){
        return DEVICE.get();
    }

}
