package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wrapper {
    public static void click(WebDriver driver, By by) {
        try {
            (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
            driver.findElement(by).click();
        } catch (TimeoutException toe) {
            Log.info("Element identified by " + by.toString() + " was not clickable after 10 seconds");
        }
    }
}
