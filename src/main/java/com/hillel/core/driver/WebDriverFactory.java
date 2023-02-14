package com.hillel.core.driver;

import com.hillel.core.Browsers;
import com.hillel.util.ConfigProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;


public class WebDriverFactory {

    private static final String BROWSER = System.getProperty("browser");
    private static WebDriver driver;

    public static WebDriver getDriver() {
        String browserType = BROWSER != null ? BROWSER : ConfigProvider.getBROWSER();
        return getDriver(Browsers.valueOf(browserType.toUpperCase()));
    }

    public static WebDriver getDriver(Browsers browser) {
        switch (browser) {
            case CHROME:
                return getChromeDriver();
            case SAFARI:
                return getSafariDriver();
            case FIREFOX:
                return getFirefoxDriver();
            case OPERA:
                return getOperaDriver();
            default:
                throw new IllegalArgumentException("Wrong browser was chosen");
        }
    }

    public static WebDriver getChromeDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static WebDriver getSafariDriver() {
        if (driver == null) {
            WebDriverManager.safaridriver().driverVersion("16.1").setup();
            driver = new SafariDriver();
        }
        return driver;
    }

    public static WebDriver getFirefoxDriver() {
        if (driver == null) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public static WebDriver getOperaDriver() {
        if (driver == null) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        }
        return driver;
    }


}
