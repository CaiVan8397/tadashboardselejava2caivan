package sele2.com.driver;

import org.openqa.selenium.WebDriver;
import sele2.com.enums.BrowserType;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void createDriver(BrowserType type) {
        driver.set(WebDriverFactory.getWebDriver(type));
    }

    public static WebDriver driver() {
        return driver.get();
    }

    public static void closeDriver() {
        driver().close();
        driver.remove();
    }
}
