import com.hillel.core.driver.WebDriverFactory;
import com.hillel.util.ConfigProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.hillel.util.WaitUtils.waitUntilElementIsVisible;

public class TestRunner {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver();
        driver.get(ConfigProvider.getBaseUrl());

        WebElement element = driver.findElement(By.xpath("//div//a[contains(@href,'https://ithillel.ua/courses/testing')]"));
        waitUntilElementIsVisible(driver, element);

        element.click();
        driver.quit();
    }
}
