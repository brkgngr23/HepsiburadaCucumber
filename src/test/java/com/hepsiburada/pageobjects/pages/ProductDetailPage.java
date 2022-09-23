package com.hepsiburada.pageobjects.pages;

import com.hepsiburada.pageobjects.locators.ProductDetailLocators;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.hepsiburada.core.utils.log;



public class ProductDetailPage extends BasePage {

    public ProductDetailPage(RemoteWebDriver driver) {
        super(driver);
    }

    public void urunYorumuBegen() {
        browser.click(ProductDetailLocators.degerlendirmelerButton);
        int yorumSayisi= driver.findElements(ProductDetailLocators.yorumBegenIcon).size();
        if (yorumSayisi>0){
            JavascriptExecutor j = (JavascriptExecutor)driver;
            j.executeScript("window.scrollBy(0,500)");
            driver.findElements(ProductDetailLocators.yorumBegenIcon).get(0).click();
            Assert.assertEquals("Teşekkür Ederiz.",driver.findElements(ProductDetailLocators.tesekkurEderizTxt).get(0).getText());
            log.info("Urune yapilan ilk yorum begenildi");
            log.info("Tesekkur ederiz text'i goruldu.");
        }
        else {
            log.info("Urunde yorum yok!");
        }
    }


}
