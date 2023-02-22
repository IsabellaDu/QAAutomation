package testNg;

import com.hillel.core.driver.WebDriverFactory;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

@Log4j2
public class BaseTest {
    protected WebDriver driver;

    @BeforeSuite
    public void beforeAll() {
        driver = WebDriverFactory.getDriver();
    }

    @BeforeMethod
    public void testStartedLog(Method method) {
        log.info(String.format("Test %s started", method.getName()));
    }

    @AfterSuite
    public void afterAll() {
        driver.quit();
    }

    @AfterMethod
    public void testFinishedLog(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            log.info(String.format("Test %s finished with result SUCCESS", result.getName()));
        } else if (result.getStatus() == ITestResult.FAILURE) {
            log.info(String.format("Test %s finished with result FAILED", result.getName()));
        }
    }
}
