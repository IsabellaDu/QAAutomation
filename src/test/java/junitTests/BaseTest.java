package junitTests;

import com.hillel.core.driver.WebDriverFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeAll
    public static void beforeClass() {
        driver = WebDriverFactory.getDriver();
    }

    @AfterAll
    public static void afterAll() {
        driver.quit();
    }
}
