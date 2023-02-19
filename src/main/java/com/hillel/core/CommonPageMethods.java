package com.hillel.core;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.hillel.util.WaitUtils.*;

public class CommonPageMethods {

    public CommonPageMethods() {
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

    public static void scrollPageWithDynamicElToBottom(WebDriver driver) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long lastHeight = 0;
        while (true) {
            Long height = (Long) js.executeScript("return document.body.scrollHeight");
            if (lastHeight == height) {
                break;
            }
            Thread.sleep(1200);
            driver.findElement(By.tagName("body")).sendKeys(Keys.END);
            lastHeight = height;
        }
    }

    public static void scrollPageWithDynamicElToBottomUsingClassAction(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long lastHeight = 0;
        Actions action = new Actions(driver);

        while (true) {
            Long height = (Long) js.executeScript("return document.body.scrollHeight");
            if (lastHeight == height) {
                break;
            }
            action.pause(1200);
            action.sendKeys(Keys.END).perform();
            lastHeight = height;
        }
    }

    public static void scrollPageWithDynamicElToBottomUsingSpinner(WebDriver driver) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        By spinnerPath = By.xpath("//div[@class='posts_spinner']");
        while (ExpectedConditions.invisibilityOfElementLocated(spinnerPath).apply(driver) == false) {
            js.executeScript("document.querySelector('.posts_spinner').scrollIntoView()");
            Thread.sleep(1000);
        }
    }
}
