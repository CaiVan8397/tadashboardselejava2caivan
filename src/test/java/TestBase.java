import helper.BrowserHelper;
import helper.Constant;
import helper.Log;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {
    @BeforeMethod
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser) {
        WebDriverWait wait;
        Log.info("Pre-condition");
        BrowserHelper.startDriver();
        BrowserHelper.navigateToUrl(Constant.GOOGLE_URL);
    }

    @AfterMethod
    public void afterMethod() {
        Log.info("Post-condition");
        BrowserHelper.quitBrowser();
    }
}
