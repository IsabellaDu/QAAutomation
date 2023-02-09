import com.hillel.core.driver.WebDriverFactory;
import com.hillel.util.ConfigProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.hillel.util.WaitUtils.waitUntilElementIsClickable;
import static com.hillel.util.WaitUtils.waitUntilElementIsVisible;

public class TestRunner {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver();
        driver.get(ConfigProvider.getBaseUrl());

        WebElement elTestingCourseCta = driver.findElement(By.xpath("//div//a[contains(@href,'https://ithillel.ua/courses/testing')]"));
        waitUntilElementIsClickable(driver, elTestingCourseCta);


        elTestingCourseCta.click();
        WebElement elTitleOfCourse = driver.findElement(By.xpath("//div/h1[contains(@class,'hero-title')]"));
        waitUntilElementIsVisible(driver, elTitleOfCourse);
        driver.quit();
    }
}
