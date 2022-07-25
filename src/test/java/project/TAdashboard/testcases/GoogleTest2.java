package project.TAdashboard.testcases;

import common.TestBase;
import sele2.com.constants.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import sele2.com.pages.GooglePage;
import sele2.com.utilities.Actions;

public class GoogleTest2 extends TestBase {
    private final GooglePage googlePage = new GooglePage();
    String keyword = "Phonics song";

    @Test(description = "Google page 2")
    public void theBeatlesGoogleSearchTest() {
        Actions.navigateToUrl(Constant.GOOGLE_URL);
        googlePage.searchKey(keyword);
        Assert.assertTrue(googlePage.doesTheMainResultContainKeyWord(keyword), "Some results in the main result do not contain the keyword: " + keyword);
   }
}
