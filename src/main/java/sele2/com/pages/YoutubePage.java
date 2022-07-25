package sele2.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sele2.com.driver.DriverManager;

public class YoutubePage {
    WebDriverWait wait;
    private final By videoScreen = By.xpath("//div[@id='movie_player']");
    private final By playButton = By.xpath("//button[@aria-label='Play']");
    private final By currentTime = By.className("ytp-time-current");
    private final By title = By.xpath("//div[@id='container']/h1");

    public void playVideo() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(playButton));
        DriverManager.getDriver().findElement(playButton).click();
    }

    public void pauseVideoAt(String time) {
        Actions actions = new Actions( DriverManager.getDriver());
        while (!getCurrentTime().equals(time)) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(title));
            actions.moveToElement( DriverManager.getDriver().findElement(title)).build().perform();
            actions.moveToElement( DriverManager.getDriver().findElement(videoScreen)).build().perform();
        }
        actions.sendKeys(Keys.SPACE).build().perform();
    }

    public String getCurrentTime() {
        return  DriverManager.getDriver().findElement(currentTime).getText();
    }
}
