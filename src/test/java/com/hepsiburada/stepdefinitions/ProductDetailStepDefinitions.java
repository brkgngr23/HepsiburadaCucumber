package com.hepsiburada.stepdefinitions;


import com.hepsiburada.pageobjects.pages.ProductDetailPage;
import com.hepsiburada.core.configurations.DriverBase;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class ProductDetailStepDefinitions {

    private final ProductDetailPage productDetailPage;
    private final RemoteWebDriver driver;


    public ProductDetailStepDefinitions(DriverBase driverBase) {
        driver = driverBase.createWebDriverInstance();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        productDetailPage = new ProductDetailPage(driver);

    }

    @When("I like the comment if has it")
    public void urunYorumuBegen() {
        productDetailPage.urunYorumuBegen();
    }

}

