package sele2.com.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import sele2.com.driver.DriverManager;

public class Actions {
    private static final ThreadLocal<WebDriver> localDriver = new ThreadLocal<>();

    private static final SoftAssert softAssert = new SoftAssert();

    public static void stopSoftAssertAll() {
        softAssert.assertAll();
    }


    public static void setDriver(WebDriver driver) {
        localDriver.set(driver);
    }

    public static WebDriver driver() {
        return localDriver.get();
    }

    public static void open(String url) {
        driver().get(url);
    }

    public static WebElement findElement(By locator) {
        return driver().findElement(locator);
    }

    public static void clearText(By locator) {
        findElement(locator).clear();
    }

    public static void sendKeys(By locator, String key) {
        findElement(locator).sendKeys(key);
    }

    public static String getAttribute(By locator, String attribute) {
        return findElement(locator).getAttribute(attribute);
    }

    public static void navigateToUrl(String url) {
        DriverManager.driver().get(url);
    }

    public static String getText(By locator) {
        return findElement(locator).getText();
    }


    public static void click(By locator) {
        findElement(locator).click();
    }
}
