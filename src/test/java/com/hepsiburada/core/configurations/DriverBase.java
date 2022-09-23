package com.hepsiburada.core.configurations;

import com.hepsiburada.core.configurations.DriverFactory;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DriverBase {

    public static List<DriverFactory> webDriverThreadPool = Collections.synchronizedList(new ArrayList<>());
    public static ThreadLocal<DriverFactory> webDriverThreadLocal;


    public RemoteWebDriver createWebDriverInstance() {
        return webDriverThreadLocal.get().createInstance();
    }

    public RemoteWebDriver getWebDriver() {
        return webDriverThreadLocal.get().getWebDriver();
    }

    public void quitWebDriver() {
        webDriverThreadPool.forEach(DriverFactory::quitWebDriver);
    }

}
