package com.hepsiburada.core.configurations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public enum BrowserType {

    CHROME {
        @Override
        public RemoteWebDriver createWebDriver() {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver(getOptions());
        }

        @Override
        public ChromeOptions getOptions() {
            Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);

            Map<String, Object> prefs = new HashMap<>();
            prefs.put("profile.default_content_setting_values.notifications", 1);
            prefs.put("profile.managed_default_content_settings.javascript", 1);
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);

            LoggingPreferences chromeLogPrefs = new LoggingPreferences();
            chromeLogPrefs.enable(LogType.PERFORMANCE, Level.OFF);

            ChromeOptions chromeOptions = new ChromeOptions();

            chromeOptions.setCapability(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            chromeOptions.setCapability(ChromeDriverService.CHROME_DRIVER_VERBOSE_LOG_PROPERTY, "true");
            chromeOptions.setCapability(CapabilityType.LOGGING_PREFS, chromeLogPrefs);
            chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            chromeOptions.addArguments("--no-sandbox", "--disable-gpu", "--disable-logging", "--disable-dev-shm-usage");
            chromeOptions.setAcceptInsecureCerts(true);
            chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            chromeOptions.setHeadless(HEADLESS);
            chromeOptions.setExperimentalOption("prefs", prefs);

            return chromeOptions;
        }
    },

    FIREFOX {
        @Override
        public RemoteWebDriver createWebDriver() {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver(getOptions());
        }

        @Override
        public FirefoxOptions getOptions() {
            Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);

            FirefoxOptions firefoxOptions = new FirefoxOptions();

            FirefoxProfile firefoxProfile = new FirefoxProfile();
            firefoxProfile.setPreference(FirefoxDriver.MARIONETTE, true);
            firefoxProfile.setAcceptUntrustedCertificates(true);
            firefoxProfile.setAssumeUntrustedCertificateIssuer(true);

            LoggingPreferences firefoxLogPrefs = new LoggingPreferences();
            firefoxLogPrefs.enable(LogType.PERFORMANCE, Level.OFF);

            firefoxOptions.setCapability(CapabilityType.LOGGING_PREFS, firefoxLogPrefs);
            firefoxOptions.setCapability(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
            firefoxOptions.setLogLevel(FirefoxDriverLogLevel.ERROR);
            firefoxOptions.setProfile(firefoxProfile);
            firefoxOptions.addPreference("dom.webnotifications.enabled", false);
            firefoxOptions.addPreference("gfx.direct2d.disabled", true);
            firefoxOptions.addPreference("layers.acceleration.force-enabled", true);
            firefoxOptions.addPreference("javascript.enabled", true);
            firefoxOptions.setHeadless(HEADLESS);

            return firefoxOptions;
        }
    };

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }

    public final static boolean HEADLESS = Boolean.getBoolean("headless");

    protected abstract RemoteWebDriver createWebDriver();

    protected abstract MutableCapabilities getOptions();
}
