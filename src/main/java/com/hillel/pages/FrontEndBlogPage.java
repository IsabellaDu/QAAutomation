package com.hillel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.hillel.util.WaitUtils.waitUntilElementIsVisible;

public class FrontEndBlogPage extends BasePage {

    private static final String FRONT_END_BLOG_URL = "https://blog.ithillel.ua/publications/frontend";

    @FindBy(xpath = "//div/ul[@class='posts_list post-list']/li")
    private List<WebElement> elFrontEndArticlesList;

    @FindBy(xpath = "//a[@class='site-logo-link -pinned']")
    private WebElement elBlogPageLogoCta;

    public FrontEndBlogPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void open() {
        super.driver.get(FRONT_END_BLOG_URL);
    }

    @Override
    public void ensureOpened() {
        waitUntilElementIsVisible(driver, elBlogPageLogoCta);

    }

    public WebElement getElBlogPageLogoCta() {
        return elBlogPageLogoCta;
    }

    public int getFullAmountOfFrontEndArticles() {
        return elFrontEndArticlesList.size();
    }
}
