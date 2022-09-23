package com.hepsiburada.core.synchronizations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitFactory {

    private final WebDriverWait wait;

    public WaitFactory(WebDriver driver) {
        wait = new WebDriverWait(driver, 20);
    }

    public WebElement waitForPresenceOfElementLocated(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement waitForElementVisible(By locator) {
        WebElement element = waitForPresenceOfElementLocated(locator);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public WebElement waitForElementIsClickable(By locator) {
        WebElement element = waitForPresenceOfElementLocated(locator);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public WebElement waitForElementIsTextTypable(By locator) {
        WebElement element = waitForPresenceOfElementLocated(locator);
        wait.until(CustomExpectedConditions.elementToBeTextTypable(locator));
        return element;
    }

    public void waitForElementContainsText(By locator, String partialText) {
        WebElement element = waitForPresenceOfElementLocated(locator);
        wait.until(ExpectedConditions.textToBePresentInElement(element, partialText));
    }

    public Select waitForElementToBeSelectable(By locator) {
        WebElement element = waitForElementVisible(locator);
        Select select = new Select(element);
        wait.until(CustomExpectedConditions.optionsToBeSelectable(select));
        return select;
    }
}
