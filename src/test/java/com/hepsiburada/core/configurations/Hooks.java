package com.hepsiburada.core.configurations;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import com.hepsiburada.core.utils.log;


import static com.hepsiburada.core.configurations.DriverBase.*;

public class Hooks {

    private final DriverBase driverBase;

    public Hooks(DriverBase driverBase) {
        this.driverBase = driverBase;
    }

    @Before()
    public void beforeScenario(Scenario scenario) {
        webDriverThreadLocal = ThreadLocal.withInitial(() -> {
            DriverFactory driverFactory = new DriverFactory();
            webDriverThreadPool.add(driverFactory);
            return driverFactory;
        });


        log.info(String.format("Scenario started : %s", scenario.getName()));
    }

    @After()
    public void afterScenario(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            File screenshotAs = ((TakesScreenshot) driverBase.getWebDriver()).getScreenshotAs(OutputType.FILE);
            Allure.addAttachment("Screenshot", FileUtils.openInputStream(screenshotAs));
        }

        driverBase.quitWebDriver();
        log.info(String.format("Scenario finished : %s", scenario.getName()));
    }
}
