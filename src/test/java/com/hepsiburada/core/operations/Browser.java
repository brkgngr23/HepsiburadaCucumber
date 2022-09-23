package com.hepsiburada.core.operations;

import com.hepsiburada.core.synchronizations.WaitFactory;
import com.hepsiburada.core.utils.log;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Browser implements BrowserOperations<Browser> {


    private final WaitFactory waitFactory;
    private final WebDriver driver;

    public Browser(WebDriver driver) {
        this.driver = driver;
        waitFactory = new WaitFactory(driver);
    }

    @Override
    public Browser clickByJSExecutor(By locator) {
        try {
            WebElement element = waitFactory.waitForPresenceOfElementLocated(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            return this;
        } catch (JavascriptException exception) {
            log.error(String.format("An error occurred while the clicking the web element by JavaScript executor: \n %s",
                    ExceptionUtils.getRootCause(exception)));
            throw exception;
        }
    }

    @Override
    public Browser scrollToBottom() {
        try {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
            return this;
        } catch (JavascriptException exception) {
            log.error(String.format("An error occurred while scrolling the page: \n %s",
                    ExceptionUtils.getRootCause(exception)));
            throw exception;
        }
    }

    @Override
    public Browser scrollToElement(By locator) {
        try {
            WebElement element = waitFactory.waitForElementVisible(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            return this;
        } catch (JavascriptException exception) {
            log.error(String.format("An error occurred while scrolling the page to the element: \n %s",
                    ExceptionUtils.getRootCause(exception)));
            throw exception;
        }
    }

    @Override
    public Browser selectOptionByVisibleText(By locator, String text) {
        try {
            Select dropdown = waitFactory.waitForElementToBeSelectable(locator);
            dropdown.selectByVisibleText(text);
            return this;
        } catch (WebDriverException exception) {
            log.error(String.format("An error occurred while selecting the dropdown value: \n %s",
                    ExceptionUtils.getRootCause(exception)));
            throw exception;
        }
    }

    @Override
    public Browser selectOptionByIndex(By locator, int index) {
        try {
            Select dropdown = waitFactory.waitForElementToBeSelectable(locator);
            dropdown.selectByIndex(index);
            return this;
        } catch (WebDriverException exception) {
            log.error(String.format("An error occurred while selecting the dropdown value: \n %s",
                    ExceptionUtils.getRootCause(exception)));
            throw exception;
        }
    }

    @Override
    public Browser selectOptionByValue(By locator, String value) {
        try {
            Select dropdown = waitFactory.waitForElementToBeSelectable(locator);
            dropdown.selectByValue(value);
            return this;
        } catch (WebDriverException exception) {
            log.error(String.format("An error occurred while selecting the dropdown value: \n %s",
                    ExceptionUtils.getRootCause(exception)));
            throw exception;
        }
    }

    @Override
    public Browser click(By locator) {
        try {
            WebElement element = waitFactory.waitForElementIsClickable(locator);
            element.click();
            return this;
        } catch (StaleElementReferenceException exception) {
            log.error(String.format("DOM operation happening on this page is temporarily causing the element to be inaccessible: \n %s",
                    ExceptionUtils.getRootCause(exception)));
            throw exception;
        } catch (ElementNotInteractableException exception) {
            log.error(String.format("The element existed on the DOM but it could not have become visible: \n %s",
                    ExceptionUtils.getRootCause(exception)));
            throw exception;
        }
    }

    public Browser clickElement(By locator) {
        WebElement element = waitFactory.waitForElementIsClickable(locator);
        element.click();
        return this;
    }

    @Override
    public Browser submit(By locator) {
        try {
            WebElement element = waitFactory.waitForElementVisible(locator);
            element.submit();
            return this;
        } catch (NoSuchElementException exception) {
            log.error(String.format("The web element could not be found: \n %s",
                    ExceptionUtils.getRootCause(exception)));
            throw exception;
        }
    }

    @Override
    public Browser sendKeys(By locator, String keysToSend) {
        try {
            WebElement element = waitFactory.waitForElementIsTextTypable(locator);
            element.sendKeys(keysToSend);
            return this;
        } catch (WebDriverException exception) {
            log.error(String.format("An error occurred while typing a value to the element: \n %s",
                    ExceptionUtils.getRootCause(exception)));
            throw exception;
        }
    }

    @Override
    public Browser clear(By locator) {
        try {
            WebElement element = waitFactory.waitForElementVisible(locator);
            element.clear();
            return this;
        } catch (WebDriverException exception) {
            log.error(String.format("An error occurred while clearing the value in the element: \n %s",
                    ExceptionUtils.getRootCause(exception)));
            throw exception;
        }
    }

    @Override
    public String getText(By locator) {
        try {
            WebElement element = waitFactory.waitForElementVisible(locator);
            return element.getText();
        } catch (WebDriverException exception) {
            log.error(String.format("An error occurred while getting the text of the element: \n %s",
                    ExceptionUtils.getRootCause(exception)));
            throw exception;
        }
    }

    @Override
    public boolean isSelected(By locator) {
        try {
            WebElement element = waitFactory.waitForElementVisible(locator);
            return element.isSelected();
        } catch (WebDriverException exception) {
            log.error(String.format("An error occurred while checking if the element is selected: \n %s",
                    ExceptionUtils.getRootCause(exception)));
            throw exception;
        }
    }

    @Override
    public boolean isDisplayed(By locator) {
        try {
            WebElement element = waitFactory.waitForElementVisible(locator);
            return element.isDisplayed();
        } catch (WebDriverException exception) {
            log.error(String.format("An error occurred while checking if the web element is displayed: \n %s",
                    ExceptionUtils.getRootCause(exception)));
            throw exception;
        }
    }

    @Override
    public boolean isEnabled(By locator) {
        try {
            WebElement element = waitFactory.waitForElementVisible(locator);
            return element.isEnabled();
        } catch (WebDriverException exception) {
            log.error(String.format("An error occurred while checking if the element is enabled: \n %s",
                    ExceptionUtils.getRootCause(exception)));
            throw exception;
        }
    }

    public boolean isElementExist(By locator) {
        try {
            WebElement element = waitFactory.waitForElementVisible(locator);
            return !element.findElements(locator).isEmpty();
        } catch (WebDriverException exception) {
            log.error(String.format("An error occurred while checking if the web element is existing: \n %s",
                    ExceptionUtils.getRootCause(exception)));
            throw exception;
        }
    }

}
