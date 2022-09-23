package com.hepsiburada.core.operations;

import org.openqa.selenium.*;

public interface Operations<T> {

    /**
     * Click element type usually button ones.
     *
     * @param locator Helps to find the element to click.
     * @throws StaleElementReferenceException  If the element is detached from the current DOM.
     * @throws ElementNotInteractableException If unable to interact with the element.
     */
    T click(By locator);

    /**
     * Submit any form element inside of form tags.
     *
     * @param locator Helps to find the element to submit.
     * @throws NoSuchElementException If the element could not be found.
     */
    T submit(By locator);

    /**
     * Types a value into element.
     *
     * @param locator    Helps to find the item to type text in element.
     * @param keysToSend The sequence of characters of type string to be written into the element.
     * @throws WebDriverException If the WebDriver is acting right after you close the browser.
     */
    T sendKeys(By locator, String keysToSend);

    /**
     * Cleans the value inside the element.
     *
     * @param locator Helps to find the item to clean.
     * @throws WebDriverException If the WebDriver is acting right after you close the browser.
     */
    T clear(By locator);

    /**
     * Retrieves the innerText which the element has.
     *
     * @param locator Helps to find the element that has innerText.
     * @throws WebDriverException If the WebDriver is acting right after you close the browser.
     */
    String getText(By locator);

    /**
     * Checks whether the element is selected.
     *
     * @param locator Helps to find the element that whether selected or not.
     * @throws WebDriverException If the WebDriver is acting right after you close the browser.
     */
    boolean isSelected(By locator);

    /**
     * Checks whether the element is displayed.
     *
     * @param locator Helps to find the element that whether displayed or not.
     * @throws WebDriverException If the WebDriver is acting right after you close the browser.
     */
    boolean isDisplayed(By locator);

    /**
     * Checks whether the element is enabled.
     *
     * @param locator Helps to find the element that whether enabled or not.
     * @throws WebDriverException If the WebDriver is acting right after you close the browser.
     */
    boolean isEnabled(By locator);
}
