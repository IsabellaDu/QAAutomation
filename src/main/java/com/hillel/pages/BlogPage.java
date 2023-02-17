package com.hillel.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.hillel.util.WaitUtils.waitUntilElementIsVisible;

public class BlogPage extends BasePage {

    private static final String BLOG_URL = "https://blog.ithillel.ua";

    @FindBy(xpath = "//li[@class='theme-list_item']/a[@href='https://blog.ithillel.ua/publications/frontend']")
    private WebElement elArticlesFrontEndCta;

    @FindBy(xpath = "//li[@class='theme-list_item']/a[@href='https://blog.ithillel.ua/publications/qa']")
    private WebElement elArticlesQaCta;

    @FindBy(xpath = "//li[@class='theme-list_item']/a[@href='https://blog.ithillel.ua/publications/gamedev']")
    private WebElement elArticlesGameDevCta;


    public BlogPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void open() {
        super.driver.get(BLOG_URL);
        ensureOpened();
    }

    @Override
    public void ensureOpened() {
        waitUntilElementIsVisible(super.driver, elArticlesFrontEndCta);
    }

    public WebElement getElArticlesFrontEndCta() {
        return elArticlesFrontEndCta;
    }

    public WebElement getElArticlesQaCta() {
        return elArticlesQaCta;
    }

    public WebElement getElArticlesGameDevCta() {
        return elArticlesGameDevCta;
    }
}
