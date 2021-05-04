package com.framework.utils;

import com.framework.enums.ConfigProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public final class ReadProperty {

    private ReadProperty(){
    }

    private static Properties property = new Properties();

    static {
        try {
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/Configs/config.properties");
            property.load(file);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static String get(ConfigProperties key) {
        if(Objects.isNull(property.getProperty(String.valueOf(key).toLowerCase()))){
            throw new IllegalArgumentException("Property name = " + key + " is not found. Please check config.properties");
        }
        return property.getProperty(String.valueOf(key).toLowerCase());
    }
}





