package com.hillel.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.hillel.util.WaitUtils.waitUntilElementIsVisible;

public class BlogPage extends BasePage {

    private static final String BLOG_URL = "https://blog.ithillel.ua";

    @FindBy(xpath = "//main//section[not(contains(@class,'-hero'))]//ul//*[contains(@class, 'btn-theme')][contains(text(), 'Front-end')]")
    private WebElement elArticlesFrontEndCta;

    @FindBy(xpath = "//main//section[not(contains(@class,'-hero'))]//ul//*[contains(@class, 'btn-theme')][contains(text(), 'Тестування')]")
    private WebElement elArticlesQaCta;

    @FindBy(xpath = "//main//section[not(contains(@class,'-hero'))]//ul//*[contains(@class, 'btn-theme')][contains(text(), 'GameDev')]")
    private WebElement elArticlesGameDevCta;

    @FindBy(xpath = "//ul[@class='posts_list post-list']/li")
    private List<WebElement> elArticlesList;


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

    public WebElement getElArticlesByPathCta(String path) {
        return driver.findElement(By.xpath(path));
    }

    public int getFullAmountOfArticles() {
        return elArticlesList.size();
    }
}
