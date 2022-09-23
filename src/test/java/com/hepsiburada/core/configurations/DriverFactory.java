package com.hepsiburada.core.configurations;

import com.hepsiburada.core.utils.PropertyUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class DriverFactory {

    private static final Logger LOGGER = (Logger) LogManager.getLogger(DriverFactory.class.getName());
    private static final Properties PROPERTIES = PropertyUtils.getInstance().loadPropertiesFile("auth.properties");
    private static final String SERVER_GRID_URL = PROPERTIES.getProperty("grid.ip.address");
    private static final String SERVER_GRID_PORT = PROPERTIES.getProperty("grid.port");
    private final BrowserType selectedBrowser;
    private final boolean useSeleniumGrid = Boolean.getBoolean("remote");
    private RemoteWebDriver driver;

    public DriverFactory() {
        BrowserType currentBrowser = BrowserType.CHROME;
        String browser = System.getProperty("browser", currentBrowser.toString()).toUpperCase();

        try {
            currentBrowser = BrowserType.valueOf(browser);
        } catch (IllegalArgumentException | NullPointerException ignored) {
            LOGGER.warn(String.format("Unknown driver specified, defaulting to '%s'...", currentBrowser));
        }
        selectedBrowser = currentBrowser;
    }

    public RemoteWebDriver createInstance() {
        if (null == driver) {
            instantiateWebDriver(selectedBrowser);
        }
        return driver;
    }

    public RemoteWebDriver getWebDriver() {
        return driver;
    }

    public void quitWebDriver() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }

    private void instantiateWebDriver(BrowserType selectedBrowser) {
        if (useSeleniumGrid) {
            try {
                driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/wd/hub", SERVER_GRID_URL, SERVER_GRID_PORT)), selectedBrowser.getOptions());
            } catch (MalformedURLException exception) {
                LOGGER.error(String.format("A malformed URL has occurred. No legal protocol could be found or string could not be parsed: \n %s",
                        ExceptionUtils.getRootCause(exception)));
            }
        } else {
            driver = selectedBrowser.createWebDriver();
        }
    }
}
