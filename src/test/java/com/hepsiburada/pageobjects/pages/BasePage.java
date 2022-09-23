package com.hepsiburada.pageobjects.pages;

import com.hepsiburada.core.operations.Browser;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BasePage {

    protected RemoteWebDriver driver;
    protected Browser browser;

    public BasePage(RemoteWebDriver driver) {
        this.driver = driver;
        browser = new Browser(driver);
    }
}
