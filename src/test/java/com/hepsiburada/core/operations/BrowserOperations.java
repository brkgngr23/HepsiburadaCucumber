package com.hepsiburada.core.operations;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriverException;

public interface BrowserOperations<T> extends Operations<T> {

    /**
     * Clicks the element using JavaScriptExecutor.
     *
     * @param locator Helps to find the element id to click.
     * @throws JavascriptException If executing JavaScript given by the user.
     */
    T clickByJSExecutor(By locator);

    /**
     * Scrolls the page to bottom using JavaScriptExecutor.
     *
     * @throws JavascriptException If executing JavaScript given by the user.
     */
    T scrollToBottom();

    /**
     * Scrolls down the page till the web element is found using JavaScriptExecutor.
     *
     * @param locator Helps to find to scroll to the element.
     * @throws JavascriptException If executing JavaScript given by the user.
     */
    T scrollToElement(By locator);

    /**
     * Selects an option by using the visible text belongs to each option in the drop-down menu.
     *
     * @param locator Helps to find the element that whether enabled or not.
     * @param text    The text of the option to be selected
     * @throws WebDriverException If the WebDriver is acting right after you close the browser.
     */
    T selectOptionByVisibleText(By locator, String text);

    /**
     * Selects an option by using the index related to each option in the drop-down menu.
     *
     * @param locator Helps to find the element that whether enabled or not.
     * @param index   The index of the option to be selected
     * @throws WebDriverException If the WebDriver is acting right after you close the browser.
     */
    T selectOptionByIndex(By locator, int index);

    /**
     * Selects an option by using the value attribute provided for each option in the drop-down menu.
     *
     * @param locator Helps to find the element that whether enabled or not.
     * @param value   The value of the option to be selected
     * @throws WebDriverException If the WebDriver is acting right after you close the browser.
     */
    T selectOptionByValue(By locator, String value);
}
