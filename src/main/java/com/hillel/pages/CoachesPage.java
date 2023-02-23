package com.hillel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.hillel.util.WaitUtils.waitUntilElementIsVisible;

public class CoachesPage extends BasePage {
    private static final String COACHES_URL = "https://ithillel.ua/coaches";

    @FindBy(xpath = "//div//button[@data-modal='become-coach']")
    private WebElement elBecomeCoachCta;

    public CoachesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void open() {
        super.driver.get(COACHES_URL);
        ensureOpened();
    }

    @Override
    public void ensureOpened() {
        waitUntilElementIsVisible(driver, elBecomeCoachCta);
    }

    public WebElement getElBecomeCoachCta() {
        return elBecomeCoachCta;
    }
}
