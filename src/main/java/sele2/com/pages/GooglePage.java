package sele2.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import sele2.com.driver.DriverManager;
import sele2.com.utilities.Actions;

import java.util.List;
import java.util.stream.Collectors;

public class GooglePage {

    private final By searchBox = By.xpath("//input[@name='q' and @role='combobox']");
    private final By mainResults = By.xpath("//div[@id='search']/div/div/div[not(contains(.,'People also ask'))]//a/h3");
    private final By peopleAlsoAskResults = By.xpath("//div[@id='search']/div/div/div[contains(.,'People also ask')]//a/h3");
    private final By videosResults = By.xpath("//div[@id='search']/div/div/div[contains(.,'Videos')]//a[not(contains(.,'View all'))]");
    private final By topStoriesResults = By.xpath("//div[@id='search']/div/div/div[contains(.,'Top stories')]//a//div[@role='heading']");


    public void searchKey(String keyword) {
        DriverManager.driver().findElement(searchBox).clear();
        DriverManager.driver().findElement(searchBox).sendKeys(keyword + Keys.ENTER);
    }

    public void openTheFirstVideoResult() {
        DriverManager.driver().findElement(videosResults).click();
    }

    public boolean doesSearchBoxRemainKeyWord(String keyWord) {
        return Actions.getAttribute(searchBox, "value").equals(keyWord);
    }

    public boolean doesTheMainResultContainKeyWord(String keyWord) {
        return isTheKeyWordContainedInResults(keyWord, mainResults);
    }

    public boolean doesThePeopleAlsoAskContainKeyWord(String keyWord) {
        return isTheKeyWordContainedInResults(keyWord, peopleAlsoAskResults);
    }

    public boolean doesTopStoriesContainKeyWord(String keyWord) {
        return isTheKeyWordContainedInResults(keyWord, videosResults);
    }

    public boolean doesTheVideosContainKeyWord(String keyWord) {
        return isTheKeyWordContainedInResults(keyWord, topStoriesResults);
    }

    private boolean isTheKeyWordContainedInResults(String keyWord, By locator) {
        List<String> results = DriverManager.driver().findElements(locator).stream().map(WebElement::getText).filter(t -> !t.isEmpty()).collect(Collectors.toList());
        for (String e : results) {
            if (!e.contains(keyWord)) {
                System.out.println("The result " + e + " does not contains " + keyWord);
                return false;
            }
        }
        return true;
    }
}
