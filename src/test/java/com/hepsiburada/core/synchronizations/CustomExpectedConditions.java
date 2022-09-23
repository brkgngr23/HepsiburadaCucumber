package com.hepsiburada.core.synchronizations;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;

@SuppressWarnings("ALL")
public class CustomExpectedConditions {

    /**
     * An expectation for checking if all selectable options are present.
     *
     * @param select the select webElements
     * @return true once the total size of the select options bigger than 1.
     */
    public static ExpectedCondition<Boolean> optionsToBeSelectable(final Select select) {
        return new ExpectedCondition<Boolean>() {

            @NullableDecl
            @Override
            public Boolean apply(@NullableDecl WebDriver webDriver) {
                try {
                    return select.getOptions().size() > 1;
                } catch (StaleElementReferenceException exception) {
                    return null;
                }
            }
        };
    }

    /**
     * An expectation for checking if all selectable options are present.
     *
     * @param locator Helps to find the item
     * @return true once the type or name attribute equal to the desired conditions.
     */
    public static ExpectedCondition<Boolean> elementToBeTextTypable(final By locator) {
        return new ExpectedCondition<Boolean>() {
            @NullableDecl
            @Override
            public Boolean apply(@NullableDecl WebDriver webDriver) {
                String inputType = webDriver.findElement(locator).getAttribute("type");
                String inputName = webDriver.findElement(locator).getAttribute("name");
                try {
                    if (inputType.contains("text") ||
                            inputType.contains("mail") ||
                            inputType.contains("password") ||
                            inputType.contains("number") ||
                            inputName.contains("message") ||
                            inputName.contains("inAppText") ||
                            inputName.contains("reply")) {
                        return true;
                    }
                    return null;
                } catch (StaleElementReferenceException exception) {
                    return null;
                }
            }
        };
    }
}
