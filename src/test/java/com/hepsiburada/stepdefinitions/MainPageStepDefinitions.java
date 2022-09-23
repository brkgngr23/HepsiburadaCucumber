package com.hepsiburada.stepdefinitions;

import com.hepsiburada.pageobjects.pages.MainPage;
import com.hepsiburada.core.configurations.DriverBase;
import io.cucumber.java.en.*;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class MainPageStepDefinitions {


    private final MainPage mainPage;
    private final RemoteWebDriver driver;

    public MainPageStepDefinitions(DriverBase driverBase) {
        driver = driverBase.createWebDriverInstance();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        mainPage = new MainPage(driver);


    }

    @Given("Navigate to dashboard")
    public void navigatePage() {
        mainPage.navigate();
    }

    @Then("I search {string} product")
    public void searchProduct(String productName) {
        mainPage.searchProduct(productName);
    }


}

