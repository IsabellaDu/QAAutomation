package com.hillel.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.hillel.util.WaitUtils.waitUntilElementIsVisible;

public class CheckCertificatePage extends BasePage {
    private static final String CERTIFICATE_URL = "https://certificate.ithillel.ua/";

    @Getter
    @FindBy(xpath = "//input[@class='input -text certificate-check_input']")
    private WebElement elNumberOfCertificateInput;

    @Getter
    @FindBy(xpath = "//button[@class='btn btn-submit -submit certificate-check_submit']")
    private WebElement elCheckCertificateCta;
    @Getter
    @FindBy(xpath = "//p[@class='certificate-check_message']")
    private WebElement elCertificateMessage;

    public CheckCertificatePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void open() {
        super.driver.get(CERTIFICATE_URL);
        ensureOpened();
    }

    @Override
    public void ensureOpened() {
        waitUntilElementIsVisible(super.driver, elNumberOfCertificateInput);
    }

    public void setNumberOfCertificate(String number) {
        this.elNumberOfCertificateInput.sendKeys(number);
    }
}
