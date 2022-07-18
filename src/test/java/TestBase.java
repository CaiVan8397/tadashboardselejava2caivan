import helper.BrowserHelper;
import helper.Log;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {
    @BeforeMethod
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser) {
        Log.info("Pre-condition");
        BrowserHelper.startDriver();
    }

    @AfterMethod
    public void afterMethod() {
        Log.info("Post-condition");
        BrowserHelper.quitBrowser();
    }
}
