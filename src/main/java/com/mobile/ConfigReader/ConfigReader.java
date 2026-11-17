package com.mobile.ConfigReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ConfigReader {
private static final String CONFIG_FILE_PATH = "src/main/resources/config.properties";
public static Properties ppty;

static{
    ppty = new Properties();
    try(FileInputStream fis = new FileInputStream(CONFIG_FILE_PATH)){
        ppty.load(fis);

    } catch (IOException e) {
        e.printStackTrace();
    }
}

}