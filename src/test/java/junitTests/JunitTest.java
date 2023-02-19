package junitTests;

import com.hillel.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.hillel.core.CommonPageMethods.*;

public class JunitTest extends BaseTest {

    HomePage homePage = new HomePage(driver);
    BlogPage blogPage = new BlogPage(driver);

    private static Stream<Arguments> data() {
        String frontEndComponentPath = "//main//section[not(contains(@class,'-hero'))]//ul//*[contains(@class, 'btn-theme')][contains(text(), 'Front-end')]";
        String qaComponentPath = "//main//section[not(contains(@class,'-hero'))]//ul//*[contains(@class, 'btn-theme')][contains(text(), 'Тестування')]";
        String gameDevComponentPath = "//main//section[not(contains(@class,'-hero'))]//ul//*[contains(@class, 'btn-theme')][contains(text(), 'GameDev')]";
        int amountExpectedFrontEndArticles = 121;
        int amountExpectedQAArticles = 87;
        int amountExpectedGameDevArticles = 5;

        return Stream.of(
                Arguments.of(frontEndComponentPath, amountExpectedFrontEndArticles),
                Arguments.of(qaComponentPath, amountExpectedQAArticles),
                Arguments.of(gameDevComponentPath, amountExpectedGameDevArticles));
    }

    @ParameterizedTest
    @MethodSource("data")
    public void checkAmountOfArticles(String path, int amountOfExpectedArticles) {
        homePage.open();
        homePage.getElBlogCta().click();
        blogPage.getElArticlesByPathCta(path).click();
        scrollPageWithDynamicElToBottomUsingClassAction(driver);
        Assertions.assertEquals(amountOfExpectedArticles, blogPage.getFullAmountOfArticles(), "expected amount of articles doesn't match actual amount");
    }
}
