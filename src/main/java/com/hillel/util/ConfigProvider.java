package com.hillel.util;

import lombok.Getter;

import java.io.IOException;
import java.util.Properties;

public class ConfigProvider {

    private static final String CONFIG_PATH = "config.properties";
    private static final Properties prop = initProperties();

    private static final String BROWSER = prop.getProperty("browser");
    private static final String BASE_URL = prop.getProperty("base.url");
    @Getter
    private static final String BASE_API_URL = prop.getProperty("base.api.url");
    @Getter
    private static final String BASE_API_PATH = prop.getProperty("path");

    private ConfigProvider() {
    }

    public static String getBROWSER() {
        return BROWSER;
    }

    public static String getBaseUrl() {
        return BASE_URL;
    }

    private static Properties initProperties() {
        Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemResourceAsStream(CONFIG_PATH));
        } catch (IOException e) {
            throw new RuntimeException("Could not load property file");
        }
        return properties;
    }
}
