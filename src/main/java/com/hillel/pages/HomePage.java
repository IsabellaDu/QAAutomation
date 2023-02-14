package com.hillel.pages;

import com.hillel.util.ConfigProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.hillel.util.WaitUtils.waitUntilElementIsVisible;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div//a[contains(@href,'https://ithillel.ua/courses/testing')]")
    private WebElement elTestingCourseCta;

    @FindBy(xpath = "//div/p[contains(@class, \"section-content_descriptor\")]")
    private WebElement elPageTitle;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void open() {
        super.driver.get(ConfigProvider.getBaseUrl());
        ensureOpened();
    }

    @Override
    public void ensureOpened() {
        waitUntilElementIsVisible(super.driver, elPageTitle);
    }

    public WebElement getElTestingCourseCta() {
        return elTestingCourseCta;
    }
}
