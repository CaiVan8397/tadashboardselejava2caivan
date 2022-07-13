package utilities.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Actions {
    private static final ThreadLocal<WebDriver> localDriver = new ThreadLocal<>();

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

    public static String getText(By locator) {
        return findElement(locator).getText();
    }


    public static void click(By locator) {
        findElement(locator).click();
    }
}
