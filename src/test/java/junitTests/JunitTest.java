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
        String frontEndComponentText = "Front-end";
        String qaComponentText = "Тестування";
        String gameDevComponentText = "GameDev";
        int amountExpectedFrontEndArticles = 121;
        int amountExpectedQAArticles = 87;
        int amountExpectedGameDevArticles = 5;
        return Stream.of(
                Arguments.of(frontEndComponentText, amountExpectedFrontEndArticles),
                Arguments.of(qaComponentText, amountExpectedQAArticles),
                Arguments.of(gameDevComponentText, amountExpectedGameDevArticles));
    }

    @ParameterizedTest(name = "{index} => elText={0}, amountOfExpectedArticles={1}")
    @MethodSource("data")
    public void checkAmountOfArticles(String elText, int amountOfExpectedArticles) {
        homePage.open();
        homePage.getElBlogCta().click();
        blogPage.clickToElTheme(elText);
        scrollPageWithDynamicElToBottomUsingClassAction(driver);
        Assertions.assertEquals(amountOfExpectedArticles, blogPage.getFullAmountOfArticles(), "expected amount of articles doesn't match actual amount");
    }
}
