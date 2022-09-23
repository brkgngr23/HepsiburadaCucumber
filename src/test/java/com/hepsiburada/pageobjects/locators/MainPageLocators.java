package com.hepsiburada.pageobjects.locators;

import org.openqa.selenium.By;

public class MainPageLocators {

    public static final By loginButton = By.xpath("//div[@id='myAccount']");
    public static final By searchInput = By.cssSelector("[placeholder='Ürün, kategori veya marka ara']");
    public static final By searchButton = By.xpath("//div[contains(text(),'ARA')]");
}
