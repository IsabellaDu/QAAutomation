package com.hillel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.hillel.util.WaitUtils.waitUntilElementIsVisible;

public class QAAutomationCoursePage extends BasePage {

    private static final String QA_COURSE_URL = "https://ithillel.ua/courses/qa-automation";

    @FindBy(xpath = "//div[contains(@class,'site-nav_logo')]")
    private WebElement elHillelLogoCta;

    @FindBy(xpath = "//div/h1[contains(@class,'course-descriptor_header')]")
    private WebElement elCourseTitle;

    private final By elCourseTitlePath = By.xpath("//div/h1[contains(@class,'course-descriptor_header')]");

    @FindBy(xpath = "//div[contains(@class,'course-rating')]/span[contains(@class,'course-rating_average')]")
    private WebElement elCourseRate;

    @FindBy(xpath = "//button[contains(@id,'btn-consultation-hero')]")
    private WebElement elConsultationCta;


    public QAAutomationCoursePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void open() {
        super.driver.get(QA_COURSE_URL);
        ensureOpened();
    }

    @Override
    public void ensureOpened() {
        waitUntilElementIsVisible(super.driver, elCourseTitle);
    }

    public String getCourseTitle() {
        return elCourseTitle.getText();
    }

    public String getCourseRate() {
        return elCourseRate.getText();
    }

    public WebElement getElConsultationCta() {
        return elConsultationCta;
    }

    public By getElCourseTitlePath() {
        return elCourseTitlePath;
    }

    public WebElement getElHillelLogoCta() {
        return elHillelLogoCta;
    }
}
