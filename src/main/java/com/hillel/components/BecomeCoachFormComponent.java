package com.hillel.components;

import com.hillel.pages.CoachesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.hillel.util.WaitUtils.waitUntilElementIsClickable;
import static com.hillel.util.WaitUtils.waitUntilElementIsVisible;

public class BecomeCoachFormComponent extends CoachesPage {

    @FindBy(xpath = "//div[@id='modal']")
    private WebElement elComponent;

    @FindBy(xpath = "//input[@id='input-name-become-coach']")
    private WebElement elNameInput;
    @FindBy(xpath = "//input[@id='input-lastName-become-coach']")
    private WebElement elLastnameInput;

    @FindBy(xpath = "//*[@id='field-tel-become-coach']//div[@class='iti__flag-container']")
    private WebElement elPhoneCodeDropDown;

    @FindBy(xpath = "//ul[@id='iti-1__country-listbox']//li//span[@class='iti__country-name']")
    private List<WebElement> elsPhoneCodeList;

    @FindBy(xpath = "//input[@id='input-tel-become-coach']")
    private WebElement elPhoneNumberInput;
    @FindBy(xpath = "//input[@id='input-email-become-coach']")
    private WebElement elEmailInput;

    @FindBy(xpath = "//button[@id='listbox-btn-input-city-become-coach']")
    private WebElement elCityDropDown;

    @FindBy(xpath = "//div[@id='container-input-city-become-coach']//ul[@class='listbox_opt-list']//li")
    private List<WebElement> elsCityList;

    @FindBy(xpath = "//input[@id='input-company-become-coach']")
    private WebElement elCompanyInput;
    @FindBy(xpath = "//input[@id='input-position-become-coach']")
    private WebElement elJobPositionInput;

    @FindBy(xpath = "//input[@id='input-linkedin-become-coach']")
    private WebElement elLinkedInUrlInput;

    public BecomeCoachFormComponent(WebDriver driver) {
        super(driver);
    }

    public WebElement getElComponent() {
        return elComponent;
    }

    public void setName(String name) {
        this.elNameInput.sendKeys(name);
    }

    public void setLastName(String lastName) {
        this.elLastnameInput.sendKeys(lastName);
    }

    public WebElement getElPhoneCodeDropDown() {
        return elPhoneCodeDropDown;
    }

    public void setCountryPhoneCode(String country) {
        waitUntilElementIsVisible(driver, this.elsPhoneCodeList.get(0));
        for (WebElement element : this.elsPhoneCodeList) {
            if (element.getText().contains(country)) {
                element.click();
            }
        }
    }

    public void setPhoneNumber(String phoneNumber) {
        this.elPhoneNumberInput.sendKeys(phoneNumber);
    }

    public void setEmail(String email) {
        this.elEmailInput.sendKeys(email);
    }

    public WebElement getElCityDropDown() {
        return elCityDropDown;
    }

    public void setCity(String cityCode) {
        waitUntilElementIsClickable(driver, this.elsCityList.get(0));
        for (WebElement element : this.elsCityList) {
            if (element.getAttribute("data-value").equals(cityCode)) {
                element.click();
            }
        }
    }

    public void setCompany(String companyName) {
        this.elCompanyInput.sendKeys(companyName);
    }

    public void setJobPosition(String jobPosition) {
        this.elJobPositionInput.sendKeys(jobPosition);
    }

    public void setLinkedInUrl(String linkedInUrl) {
        this.elLinkedInUrlInput.sendKeys(linkedInUrl);
    }
}
