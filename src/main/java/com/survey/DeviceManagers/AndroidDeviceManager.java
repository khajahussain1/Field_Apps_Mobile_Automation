package com.survey.DeviceManagers;

import com.survey.DeviceConfig.AndroidDeviceConfig;
import com.survey.FielReader.Android_ConfigReader;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AndroidDeviceManager {

    private static final AtomicInteger COUNTER = new AtomicInteger(0);
    private static final List<AndroidDeviceConfig> DEVICES = loadDevices();

    private static List<AndroidDeviceConfig> loadDevices() {
        int count = Android_ConfigReader.getInt("Android.devicesCount");
        List<AndroidDeviceConfig> devices = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            devices.add(new AndroidDeviceConfig(
                    Android_ConfigReader.getString("Android" + i + ".platformName"),
                    Android_ConfigReader.getString("Android" + i + ".automationName"),
                    Android_ConfigReader.getString("Android" + i + ".platformVersion"),
                    Android_ConfigReader.getString("Android" + i + ".appPath"),
                    Android_ConfigReader.getString("Android" + i + ".appPackage"),
                    Android_ConfigReader.getString("Android" + i + ".appActivity"),
                    Android_ConfigReader.getString("Android" + i + ".deviceName"),
                    Android_ConfigReader.getString("Android" + i + ".udid"),
                    Android_ConfigReader.getInt("Android" + i + ".systemPort"),
                    Android_ConfigReader.getInt("Android" + i + ".chromeDriverPort"),
                    Android_ConfigReader.getInt("Android" + i + ".mjpegServerPort")));
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


//package com.survey.DeviceManagers;
//
//import com.survey.DeviceConfig.AndroidDeviceConfig;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.concurrent.atomic.AtomicInteger;
//
//public class AndroidDeviceManager {
//
//    private static final AtomicInteger COUNTER = new AtomicInteger(0);
//    private static final ThreadLocal<AndroidDeviceConfig> DEVICE = ThreadLocal.withInitial(() -> {
//        List<AndroidDeviceConfig> devices = Arrays.asList(
//                new AndroidDeviceConfig(
//                        "Pixel 10 Pro XL API 37.0",
//                        "emulator-5554",
//                        8201,
//                        9515,
//                        7810),
//                new AndroidDeviceConfig(
//                        "Small Phone API 37.0",
//                        "emulator-5556",
//                        8202,
//                        9516,
//                        7811));
//        int index = COUNTER.getAndIncrement() % devices.size();
//        return devices.get(index);
//    });
//
//    public  static AndroidDeviceConfig getInstance(){
//        return DEVICE.get();
//    }
//
//}
