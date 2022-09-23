package com.hepsiburada.core.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtils {

    private static final Logger LOGGER = (Logger) LogManager.getLogger(PropertyUtils.class.getName());
    private static PropertyUtils propertyUtils = null;

    private PropertyUtils() {
    }

    public static PropertyUtils getInstance() {
        if (propertyUtils == null)
            propertyUtils = new PropertyUtils();
        return propertyUtils;
    }

    public Properties loadPropertiesFile(String filePath) {
        Properties prop = new Properties();
        try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(filePath)) {
            prop.load(resourceAsStream);
        } catch (IOException exception) {
            LOGGER.error(String.format("Unable to load properties file : %s %n", filePath));
        }
        return prop;
    }
}
