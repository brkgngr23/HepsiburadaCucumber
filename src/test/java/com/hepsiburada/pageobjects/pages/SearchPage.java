package com.hepsiburada.pageobjects.pages;

import com.hepsiburada.pageobjects.locators.ProductDetailLocators;
import com.hepsiburada.pageobjects.locators.SearchPageLocators;
import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.hepsiburada.core.utils.log;

import java.util.ArrayList;

public class SearchPage extends BasePage {

    public SearchPage(RemoteWebDriver driver) {
        super(driver);
    }

    public void urunSec() {
        browser.click(SearchPageLocators.ilkUrun);
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        browser.isElementExist(ProductDetailLocators.sepeteEkle);
        log.info("Urun detay sayfasina gidildi");

    }


}
