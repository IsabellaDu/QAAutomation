package com.hillel.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.hillel.util.WaitUtils.*;

public class CommonClickMethods {

    public CommonClickMethods() {
    }

    public static void clickAfterEnsureElementIsClickable(WebDriver webDriver, WebElement webElement) {
        waitUntilElementIsClickable(webDriver, webElement);
        webElement.click();
    }

    public static void clickToBtnAndCheckElementIsNotVisible(WebDriver webDriver, WebElement elBtn, By elToCheck) {
        clickAfterEnsureElementIsClickable(webDriver, elBtn);
        waitUntilElementIsNotVisible(webDriver, elToCheck);
    }

    public static void isClickable(WebDriver webDriver, WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        wait.withMessage("This element could not be found to be clickable");
    }
}
