package sele2.com.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import sele2.com.enums.BrowserType;

import java.net.MalformedURLException;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void createDriver(BrowserType type) {
        driver.set(WebDriverFactory.getWebDriver(type));
    }

    public static void createDriverGrid(BrowserType type) throws MalformedURLException {
        driver.set(WebDriverFactory.getWebDriverGrid(type));
    }

    public static WebDriver driver() {
        return driver.get();
    }

    public static void closeDriver() {
        driver().quit();
        driver.remove();
    }


}
