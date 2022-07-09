import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.GooglePage;
import pages.YoutubePage;

public class GoogleTest {

    WebDriver driver = WebDriverFactory.googleDriver();
    private final GooglePage googlePage = new GooglePage(driver);
    private final YoutubePage youtubePage = new YoutubePage(driver);
    String keyword = "can't take my eyes off you";
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    void beforeMethod() {
        driver.get("https://www.google.com/");
        googlePage.searchKey(keyword);
    }

    @Test
    public void theBeatlesGoogleSearchTest() {
        softAssert.assertTrue(googlePage.doesTheMainResultContainKeyWord(keyword), "Some results in the main result do not contain the keyword: " + keyword);
        softAssert.assertTrue(googlePage.doesThePeopleAlsoAskContainKeyWord(keyword), "Some results in the People also ask result do not contain the keyword: " + keyword);
        softAssert.assertTrue(googlePage.doesTheVideosContainKeyWord(keyword), "Some results in the Videos do not contain " + keyword);
        softAssert.assertTrue(googlePage.doesTopStoriesContainKeyWord(keyword), "Some results in the Top Stories do not contain " + keyword);
        softAssert.assertTrue(googlePage.doesSearchBoxRemainKeyWord(keyword));

        softAssert.assertAll();
    }

    @Test
    public void testYoutube() {
        String timeToPause = "0:10";
        googlePage.openTheFirstVideoResult();
        youtubePage.playVideo();
        youtubePage.pauseVideoAt(timeToPause);
        Assert.assertTrue(youtubePage.getCurrentTime().equals(timeToPause), "Pause video at the wrong time");
    }

    @AfterClass
    void afterClass() {
        driver.close();
    }
}
