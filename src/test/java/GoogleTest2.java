import helper.BrowserHelper;
import helper.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GooglePage;

public class GoogleTest2 extends TestBase {
    private final GooglePage googlePage = new GooglePage();
    String keyword = "Phonics song";

    @Test(description = "Google page 2")
    public void theBeatlesGoogleSearchTest() {
        BrowserHelper.navigateToUrl(Constant.GOOGLE_URL);
        googlePage.searchKey(keyword);
        Assert.assertTrue(googlePage.doesTheMainResultContainKeyWord(keyword), "Some results in the main result do not contain the keyword: " + keyword);
   }
}
