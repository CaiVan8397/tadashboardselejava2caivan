package project.TAdashboard.testcases;

import common.TestBase;
import sele2.com.constants.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import sele2.com.pages.GooglePage;
import sele2.com.pages.YoutubePage;
import sele2.com.utilities.Actions;

public class GoogleTest extends TestBase {
    GooglePage googlePage = new GooglePage();
    YoutubePage youtubePage = new YoutubePage();
    String keyword = "Sonate";
    SoftAssert softAssert = new SoftAssert();


    @Test(description = "Google test")
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
        Actions.navigateToUrl(Constant.GOOGLE_URL);
        googlePage.searchKey(keyword);
        googlePage.openTheFirstVideoResult();
        youtubePage.playVideo();
        youtubePage.pauseVideoAt(timeToPause);
        //The test case always failed
        Assert.assertTrue(youtubePage.getCurrentTime().equals(timeToPause), "Pause video at the wrong time");
    }
}
