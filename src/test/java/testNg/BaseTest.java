package testNg;

import com.hillel.core.driver.WebDriverFactory;
import com.hillel.util.WebDriverUtils;
import io.qameta.allure.Allure;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;

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

    @AfterMethod
    public void takeScreenshot(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            File screenshot = WebDriverUtils.getScreenshot(driver);
            try {
                Allure.addAttachment("screenshot", Files.newInputStream(screenshot.toPath()));
            } catch (IOException e) {
                log.error("can not get a screenshot");
            }
        }
    }
}
