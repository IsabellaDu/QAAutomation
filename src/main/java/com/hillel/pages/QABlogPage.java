package com.hillel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.hillel.util.WaitUtils.waitUntilElementIsVisible;

public class QABlogPage extends BasePage {

    private static final String QA_BLOG_URL = "https://blog.ithillel.ua/publications/qa";

    @FindBy(xpath = "//ul[@class='posts_list post-list']/li")
    private List<WebElement> elQAArticlesList;

    @FindBy(xpath = "//a[@class='site-logo-link -pinned']")
    private WebElement elBlogPageLogoCta;

    public QABlogPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void open() {
        super.driver.get(QA_BLOG_URL);
        ensureOpened();
    }

    @Override
    public void ensureOpened() {
        waitUntilElementIsVisible(driver, elBlogPageLogoCta);
    }

    public WebElement getElBlogPageLogoCta() {
        return elBlogPageLogoCta;
    }

    public int getFullAmountOfQAArticles() {
        return elQAArticlesList.size();
    }
}
