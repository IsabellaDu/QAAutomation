package com.hillel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.hillel.util.WaitUtils.waitUntilElementIsVisible;

public class QAAutomationCoursePage extends BasePage {

    private static final String QA_COURSE_URL = "https://ithillel.ua/courses/qa-automation";

    @FindBy(xpath = "//div/h1[contains(@class, \"course-descriptor_header\")]")
    private WebElement elCourseTitle;

    @FindBy(xpath = "//div[contains(@class, \"course-rating\")]/span[contains(@class, \"course-rating_average\")]")
    private WebElement elCourseRate;

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
}
