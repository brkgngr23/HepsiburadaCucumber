package com.hepsiburada.stepdefinitions;

import com.hepsiburada.pageobjects.pages.MainPage;
import com.hepsiburada.pageobjects.pages.ProductDetailPage;
import com.hepsiburada.pageobjects.pages.SearchPage;
import com.hepsiburada.core.configurations.DriverBase;
import io.cucumber.java.en.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SearchPageStepDefinitions {

    private final SearchPage searchPage;
    private final RemoteWebDriver driver;

    public SearchPageStepDefinitions(DriverBase driverBase) {
        driver = driverBase.createWebDriverInstance();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        searchPage = new SearchPage(driver);


    }

    @Then("I choose the product")
    public void urunSec() {
        searchPage.urunSec();
    }

}
