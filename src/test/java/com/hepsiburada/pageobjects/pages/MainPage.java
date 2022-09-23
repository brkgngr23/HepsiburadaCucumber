package com.hepsiburada.pageobjects.pages;

import com.hepsiburada.core.utils.PropertyUtils;
import com.hepsiburada.pageobjects.locators.SearchPageLocators;
import com.hepsiburada.pageobjects.locators.MainPageLocators;
import io.qameta.allure.Allure;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.hepsiburada.core.utils.log;


import java.util.Properties;

public class MainPage extends BasePage {

    private final Properties props = PropertyUtils.getInstance().loadPropertiesFile("auth.properties");

    private final String url = props.getProperty("url");
    private final String email = props.getProperty("email");
    private final String password = props.getProperty("password");

    public MainPage(RemoteWebDriver driver) {
        super(driver);
    }

    public MainPage navigate() {
        driver.navigate().to(url);
        browser.isElementExist(MainPageLocators.loginButton);
        log.info("Anasayfa basarili sekilde acildi");
        return this;
    }

    public void searchProduct(String productName) {
      browser.sendKeys(MainPageLocators.searchInput,productName);
      browser.click(MainPageLocators.searchButton);
      browser.isElementExist(SearchPageLocators.ilkUrun);
      log.info(productName + " urunu basariyla arandi");
    }

}
