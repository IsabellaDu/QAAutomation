package junitTests;

import com.hillel.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.hillel.core.CommonPageMethods.scrollPageWithDynamicElToBottom;

public class JunitTest extends BaseTest {
    HomePage homePage = new HomePage(driver);
    BlogPage blogPage = new BlogPage(driver);
    FrontEndBlogPage frontEndBlogPage = new FrontEndBlogPage(driver);
    QABlogPage qaBlogPage = new QABlogPage(driver);
    GameDevBlogPage gameDevBlogPage = new GameDevBlogPage(driver);

    @Test
    public void checkAmountOfArticles() throws InterruptedException {
        homePage.open();
        homePage.getElBlogCta().click();
        blogPage.getElArticlesFrontEndCta().click();
        scrollPageWithDynamicElToBottom(driver);
        Assertions.assertEquals(121, frontEndBlogPage.getFullAmountOfFrontEndArticles(), "expected amount of FrontEnd articles doesn't match actual amount");
        frontEndBlogPage.getElBlogPageLogoCta().click();

        blogPage.getElArticlesQaCta().click();
        scrollPageWithDynamicElToBottom(driver);
        Assertions.assertEquals(87, qaBlogPage.getFullAmountOfQAArticles(), "expected amount of QA articles doesn't match actual amount");
        qaBlogPage.getElBlogPageLogoCta().click();

        blogPage.getElArticlesGameDevCta().click();
        scrollPageWithDynamicElToBottom(driver);
        Assertions.assertEquals(5, gameDevBlogPage.getFullAmountOfGameDevArticles(), "expected amount of GameDev articles doesn't match actual amount");
    }
}
