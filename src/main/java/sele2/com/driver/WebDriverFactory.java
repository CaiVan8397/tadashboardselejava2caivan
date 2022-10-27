package sele2.com.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import sele2.com.enums.BrowserType;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class WebDriverFactory {
    public static WebDriver getWebDriver(BrowserType type) {
        switch (type) {
            case CHROME:
                return getChromeDriver();
            case FIREFOX:
                return getFirefoxDriver();
            default:
                throw new RuntimeException("This driver '" + type.name() + "' is not supported or not existed!");
        }
    }

    private static ChromeDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--lang=en-GB");
        chromeOptions.addArguments("--start-maximized");
        return new ChromeDriver(chromeOptions);
    }

    private static FirefoxDriver getFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        return new FirefoxDriver(firefoxOptions);
    }

    public static WebDriver getWebDriverGrid(BrowserType type) throws MalformedURLException {
        switch (type) {
            case CHROME:
                return getChromeDriverGrid();
            case FIREFOX:
                return getFirefoxDriverGrid();
            default:
                throw new RuntimeException("This driver '" + type.name() + "' is not supported or not existed!");
        }
    }

    private static WebDriver getChromeDriverGrid() throws MalformedURLException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--lang=en-GB");
        chromeOptions.addArguments("--start-maximized");
        return new RemoteWebDriver(new URL("http://192.168.188.84:4444"), chromeOptions);
    }

    private static WebDriver getFirefoxDriverGrid() throws MalformedURLException {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        return new RemoteWebDriver(new URL("http://192.168.188.84:4444"), firefoxOptions);
    }

    public abstract DriverManager getDriverManager();

    public abstract WebDriver createDriver();

    public abstract MutableCapabilities getOptions();
}
